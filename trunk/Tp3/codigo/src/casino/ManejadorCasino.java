package casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Arrays;
import org.apache.log4j.Logger;


import casino.msg.IMSGJuego;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGEstadoCasino;
import casino.msg.MSGEstadoJugador;
import casino.msg.MSGJugador;
import casino.msg.MSGObservador;
import casino.msg.MSGPozo;
import casino.msg.MSGReporteRankingJugadores;

public class ManejadorCasino implements IServiciosCasino {

	private static ManejadorCasino instance;
	private static Logger logger = Logger.getLogger(ManejadorCasino.class);

	/**
	 * Constructor.
	 */
	private ManejadorCasino(){}
	
	/**
	 * Obtiene la unica instancia del manejador de casino. 
	 * 
	 * @return la unica instancia del manejador de casino. 
	 */
	public static ManejadorCasino getInstance()
	{
		if(instance == null)
			instance = new ManejadorCasino();
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje)
	{
		Casino casino = Casino.getInstance();
		if(!casino.isAbierto())
		{
			mensaje.setAceptado(false);
			mensaje.setDescripcion("El casino no esta abierto");
		}
		else
		{
			boolean mesasCerradas = true;
			for (ManejadorMesa m : ManejadorJugador.getInstance().getManejadores())
			{
				mesasCerradas = mesasCerradas && m.mesasCerradas();
			}
			if(!mesasCerradas)
			{
				mensaje.setAceptado(false);
				mensaje.setDescripcion("Hay jugadores jugando en el casino");
			}
			else
			{
				// guardo saldos de los jugadores
				try 
				{
					guardarListaJugadores();
				} 
				catch (CasinoException e)
				{
					logger.error(e.getMessage());
					mensaje.setAceptado(false);
					mensaje.setDescripcion(e.getMessage());
				}
				
				mensaje.setAceptado(true);
				mensaje.setDescripcion("Es casino se cerrará");
				
				// cierro realmente el casino
				casino.setAbierto(false);

				logger.info("Los jugadores se han persistido correctamente");
			}
		}
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje){
		
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		IJugador jug = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());
		
		if( jug == null && manJug.getInvitado(mensaje.getUsuario()) == null )
		{
			mensaje.setAceptado(MSGCasino.NO);
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
			logger.debug("El jugador no esta registrado como jugando en dicha terminal virtual");
		}
		else
		{	
			Set<IJugador> jugadores = manJug.getJugadores();
			Set<IInvitado> invitados = manJug.getInvitados();
			List<MSGEstadoJugador> losJugs = new ArrayList<MSGEstadoJugador>();
			List<MSGObservador> losInvitados = new ArrayList<MSGObservador>();
			
			//seteo los nombres de los jugadores TANTO OBSERVADORES COMO JUGADORES
			for ( IJugador j : jugadores )
			{	
				if(j.isLogeado())
				{
					if(j.isModoObservador())
					{
						MSGObservador msgObs = new MSGObservador();
						msgObs.setNombre(j.getNombre());
						losInvitados.add(msgObs);	
					}
					else
					{
						MSGEstadoJugador msgJug = new MSGEstadoJugador();
						msgJug.setNombre(j.getNombre());
						losJugs.add(msgJug);						
					}
				}
			}
			mensaje.setJugadores(losJugs);
			
			//seteo los nombres de los invitados
			for ( IInvitado i : invitados )
			{	
				MSGObservador msgObs = new MSGObservador();
				msgObs.setNombre(i.getNombre());
				losInvitados.add(msgObs);					
			}
			mensaje.setObservadores(losInvitados);
			
			//seteo los juegos
			List<IMSGJuego> losJuegos = new ArrayList<IMSGJuego>();
			for ( ManejadorMesa manMesa : ManejadorJugador.getInstance().getManejadores() )
			{	
				losJuegos.add(manMesa.estadoDeJuego());
			}
			mensaje.setJuegos(losJuegos);
			
			//seteo el pozo
			Casino cas = Casino.getInstance();
			MSGPozo pozo = new MSGPozo();
			pozo.setPozoFeliz(cas.getPozoFeliz());
			mensaje.setPozosCasino(pozo);
			
			mensaje.setAceptado(MSGCasino.SI);
			mensaje.setDescripcion("Se entraga el reporte del estado del casino");
		}
		
		logger.info("ESTADO CASINO jug: " + mensaje.getUsuario() + 
				" idTV: " + mensaje.getVTerm() +
				" aceptado: " + mensaje.getAceptado() +
				" descripcion: " + mensaje.getDescripcion() );	
		
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje) {
		
		Casino casino = Casino.getInstance();
		
		if(casino.isAbierto())
		{
			mensaje.setAceptado(false);
			mensaje.setDescripcion("Se deniega la reapertura del casino");
			
			logger.info("Se deniega la reapertura del casino");
		}
		else
		{
			try 
			{
				cargarListaJugadores();
				cargarGeneralidades();
				
				casino.setAbierto(true);
				mensaje.setAceptado(true);
				mensaje.setDescripcion("Se abre el casino correctamente");
				
				logger.info("Se abre el casino correctamente");
			} 
			catch (CasinoException e)
			{
				logger.error(e.getMessage());
				mensaje.setAceptado(false);
				mensaje.setDescripcion(e.getMessage());
			}
		}
		return mensaje;
	}

	/**
	 * cargarListaJugadores.
	 * 
	 * @throws CasinoException 
	 * 
	 */
	private void cargarListaJugadores() throws CasinoException
	{
		logger.info("Cargando jugadores...");
		
		List<LSTJugador> jugadores;
		try {
			jugadores = ConfigurationParser.getInstance().cargarListaJugadores();
		} catch (CasinoException e) {
			logger.error(e.getMessage());
			throw new CasinoException(e);
		}
		
		ManejadorJugador mj = ManejadorJugador.getInstance();
		
		for( LSTJugador j : jugadores)
		{
			Jugador jc = new Jugador();
			jc.setNombre(j.getNombre());
			jc.setSaldo(j.getSaldo());
			jc.setVip(j.isVip());
			mj.getJugadores().add(jc);
			logger.debug("Cargando jugador: " + j.getNombre() + " Saldo: " + j.getSaldo() + " Vip: " + j.isVip());
		}
	}
	
	private void cargarGeneralidades() throws CasinoException
	{
		Properties prop = ConfigurationParser.getInstance().cargarGeneralidades();
		
		String minimoMontoPozoFeliz = prop.getProperty("minimoMontoPozoFeliz");
		String porcentajePozoFeliz = prop.getProperty("porcentajePozoFeliz");
		
		
		if( minimoMontoPozoFeliz != null && minimoMontoPozoFeliz.length() != 0)
			Casino.getInstance().setMinPozoFeliz(Integer.parseInt(minimoMontoPozoFeliz.trim()));
		else
			throw new CasinoException("No se encuentra la property: minimoMontoPozoFeliz" );
			
		if( porcentajePozoFeliz != null && porcentajePozoFeliz.length() != 0)
			Casino.getInstance().setPorcentajePozoFeliz(Integer.parseInt(porcentajePozoFeliz.trim()));
		else
			throw new CasinoException("No se encuentra la property: porcentajePozoFeliz" );
			
	}
	
	/**
	 * guardarListaJugadores.
	 * 
	 * @throws CasinoException 
	 *  
	 */
	private void guardarListaJugadores() throws CasinoException
	{
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		
		List<LSTJugador> listajug = new ArrayList<LSTJugador>();
		
		for( IJugador j : manJug.getJugadores() )
		{
			LSTJugador jl = new LSTJugador();
			jl.setNombre(j.getNombre());
			jl.setSaldo(j.getSaldo());
			jl.setVip(j.isVip());
			logger.debug("Preparando para almacenamiento jugador: " + j.getNombre() + " Saldo: " + j.getSaldo() + " Vip: " + j.isVip());
			listajug.add(jl);
		}
		try {
			ConfigurationParser.getInstance().guardarListaJugadores(listajug);
		} catch (CasinoException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	public boolean validarFichas(List<Integer> fichas){  
		
		int i = 0;
		boolean fichaValida = true;
		Casino cas = Casino.getInstance();
		Map<Integer, Integer> valores = cas.getValores();
		while (i < fichas.size() && fichaValida == true){
			int vf = fichas.get(i);
			if(valores.containsKey(vf)){//chequeo si es una ficha valida
				
				i++;
			}else{
			  	fichaValida = false;
  					
			}
		}
		return fichaValida;
		
	}
	
		
	public int calcularMontoAApostar(List<Integer> fichas, List<Integer> cantidades){ //List<MSGValorFicha> fichas
		
		int i = 0;
		int calculoAApostar = 0;
		Casino cas = Casino.getInstance();
		Map<Integer, Integer> valores = cas.getValores();
		
		while (i < fichas.size() ){
						
			int vf = fichas.get(i);
			int cantFicha = cantidades.get(i);
			if(valores.containsKey(vf)){//chequeo si es una ficha valida
				//obtengo el significado de esa clave
				int valor = valores.get(vf);
				calculoAApostar = calculoAApostar + (cantFicha* valor);
				i++;
					
			}
		}
		
		return calculoAApostar;
	
	}
	
	public MSGReporteRankingJugadores reporteRanking(){
		
		MSGReporteRankingJugadores ranking = new MSGReporteRankingJugadores();
		List<MSGJugador> jugadoresOrdenados = new ArrayList<MSGJugador>();
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		Set<IJugador> jugadores = manJug.getJugadores();
		IJugador[] jugadoresAux = new IJugador[jugadores.size()];
		//paso de un set a un array
		int p = 0;
		for(IJugador jug : jugadores){
			
			
			jugadoresAux[p] = jug;
			p++;
		}
		
		// ordenar el array de mayor a menor segun la ganancia 
		int i = 0;
		int j = 1;
		while ( j < jugadoresAux.length ){
			IJugador jug2 = jugadoresAux[j];
			float ganJug2 = jug2.getSaldo() - jug2.getSaldoInicial();
			while(j > i){
				IJugador jug1 = jugadoresAux[i];
				float ganJug1 = jug1.getSaldo() - jug1.getSaldoInicial();
						
				if (ganJug1 < ganJug2){
				
					jugadoresAux[i] = jug2;
					jugadoresAux[j] = jug1;
				
				}
					i++;
			}	
			j++;
			i = 0;
		}
		//recorro el array ordenado y agrego a jugadores ordenados
		int q = 0;
		while(q < jugadoresAux.length){
			
			MSGJugador msgJug = new MSGJugador();
			IJugador jugador = jugadoresAux[q];
			msgJug.setJugador(jugador.getNombre());
			msgJug.setSaldo(jugador.getSaldo());
			jugadoresOrdenados.add(msgJug);
			q++;
			
		}
		ranking.setJugadores(jugadoresOrdenados);
		return ranking;
	}
	

}
