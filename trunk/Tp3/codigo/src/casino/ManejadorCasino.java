package casino;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.estadoCasino.IMSGJuego;
import casino.msg.estadoCasino.MSGEstadoCasino;
import casino.msg.estadoCasino.MSGJugador;
import casino.msg.estadoCasino.MSGObservador;
import casino.msg.estadoCasino.MSGPozo;

public class ManejadorCasino implements IServiciosCasino {

	//private static IServiciosCasino instance;
	private static ManejadorCasino instance;
	private static Logger logger = Logger.getLogger(ManejadorCasino.class);
	
	private List<ManejadorMesa> manejadores; 

	/**
	 * Constructor.
	 */
	private ManejadorCasino()
	{
		manejadores = new ArrayList<ManejadorMesa>();
	}
	
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
			for (ManejadorMesa m : getManejadores())
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
		ManejadorInvitado manInv = ManejadorInvitado.getInstance();
		
		// TODO ver puede ser cualqueir jugador ( validar invitado)
		
		if(jug == null && !(manInv.getInvitados().contains(mensaje.getUsuario())))
		{
			// TODO agregar descripcion
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugando en dicha terminal virtual");
		}
		else
		{	
			Set<IJugador> jugadores = manJug.getJugadores();
			Set<IInvitado> invitados = manJug.getInvitados();
			List<MSGJugador> losJugs = new ArrayList<MSGJugador>();
			List<MSGObservador> losInvitados = new ArrayList<MSGObservador>();
			
			//seteo los nombres de los jugadores
			for ( IJugador j : jugadores )
			{	
				MSGJugador msgJug = new MSGJugador();
				msgJug.setNombre(j.getNombre());
				losJugs.add(msgJug);						
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
			for ( ManejadorMesa manMesa : getManejadores() )
			{	
				losJuegos.add(manMesa.estadoDeJuego());
			}
			mensaje.setJuegos(losJuegos);
			
			//seteo el pozo
			Casino cas = Casino.getInstance();
			MSGPozo pozo = new MSGPozo();
			pozo.setPozoFeliz(cas.getPozoFeliz());
			mensaje.setPozosCasino(pozo);
		}
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
			} 
			catch (CasinoException e)
			{
				logger.error(e.getMessage());
				mensaje.setAceptado(false);
				mensaje.setDescripcion(e.getMessage());
			}
			
			casino.setAbierto(true);
			mensaje.setAceptado(true);
			mensaje.setDescripcion("Se abre el casino correctamente");
			
			logger.info("Se abre el casino correctamente");
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
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			throw new CasinoException(e);
		}
	}

	/**
	 * Obtiene los manejadores disponibles del casino.
	 * 
	 * @return los manejadores disponibles del casino.
	 */
	public List<ManejadorMesa> getManejadores() {
		return manejadores;
	}

	/**
	 * Setea la lista de manejadores para el casino.
	 * 
	 * @param manejadores la lista de manejadores para el casino.
	 */
	public void setManejadores(List<ManejadorMesa> manejadores) {
		this.manejadores = manejadores;
	}

	public boolean validarFichas(){  // List<MSGValorFicha> fichas
		
		//int i = 0;
		boolean fichaValida = true;
		// TODO NO PUEDE RECIBIR MSG DE CRAPS
		/*Casino cas = Casino.getInstance();
		Map<Integer, Integer> valores = cas.getValores();
		while (i < fichas.size() && fichaValida == true){
			
			MSGValorFicha vf = fichas.get(i);
				if(valores.containsKey(vf.getValor())){//chequeo si es una ficha valida
				
				i++;
			}else{
			  	fichaValida = false;
  					
			}
		}*/
		return fichaValida;
	
	}
	
	
	public int calcularMontoAApostar(){ //List<MSGValorFicha> fichas
		
		//int i = 0;
		int calculoAApostar = 0;
		/*Casino cas = Casino.getInstance();
		Map<Integer, Integer> valores = cas.getValores();
		
		while (i < fichas.size() ){
						
			MSGValorFicha vf = fichas.get(i);
			
			if(valores.containsKey(vf.getValor())){//chequeo si es una ficha valida
				//obtengo el significado de esa clave
				int valor = valores.get(vf.getValor());
				calculoAApostar = calculoAApostar + (vf.getCantidad()* valor);
				i++;
					
			}
		}*/
		
		return calculoAApostar;
	
	}
	
	
	
	
	

}