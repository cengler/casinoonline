package casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
import casino.msg.MSGReporteEstadoActual;

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
					ManejadorJugador.getInstance().guardarListaJugadores();
					guardararSaldosCasino();
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
				ManejadorJugador.getInstance().cargarListaJugadores();
				cargarGeneralidades();
				cargarFichasValidas();
				cargarSaldosCasino();
				
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

	private void cargarFichasValidas() throws CasinoException 
	{
		logger.info("Cargando fichas validas...");
		
		List<ItemApuesta> fichas;
		try 
		{
			fichas = ConfigurationParser.getInstance().cargarFichasValidas();
		} 
		catch (CasinoException e) 
		{
			logger.error(e.getMessage());
			throw new CasinoException(e);
		}
		
		Map<Integer, Integer> valoresValidos = Casino.getInstance().getValores();
		
		for (ItemApuesta ia : fichas)
			valoresValidos.put(ia.getFicha(), ia.getCantidad());
	}
	
	private void cargarGeneralidades() throws CasinoException
	{
		// CARGA DE MINIMO POZO Y PORCENTAJE DE DESCUENTO FELIZ ------------------
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
	
	private void cargarSaldosCasino() throws CasinoException
	{
		logger.info("Cargando saldos...");
		
		CFGSaldo saldos;
		try 
		{
			saldos = ConfigurationParser.getInstance().cargarSaldosCasino();
		} 
		catch (CasinoException e) 
		{
			logger.error(e.getMessage());
			throw new CasinoException(e);
		}
		
		Casino.getInstance().setSaldo(saldos.getSaldoCasino());
		Casino.getInstance().setPozoFeliz(saldos.getSaldoPozoFeliz());
	}
	
	private void guardararSaldosCasino() throws CasinoException
	{
		logger.info("Cargando saldos...");
		CFGSaldo saldos = new CFGSaldo(Casino.getInstance().getSaldo(), Casino.getInstance().getPozoFeliz());
		try 
		{
			ConfigurationParser.getInstance().guardararSaldosCasino(saldos);
		} 
		catch (CasinoException e) 
		{
			logger.error(e.getMessage());
			throw new CasinoException(e);
		}
		
	
	}
	
	/**
	 * validarFichas, valida si las fichas existen en el casino.
	 * 
	 * @param fichas conjunto de fichas a apostar
	 * @return si las fichas existen en el casino.
	 */
	public boolean validarFichas(List<ItemApuesta> itemsApuestas)
	{
		Set<Integer> fichas = new HashSet<Integer>();
		for(ItemApuesta ia : itemsApuestas)
			fichas.add(ia.getFicha());
		return Casino.getInstance().getValores().keySet().containsAll(fichas);
	}
	
	/**
	 * calcularMontoAApostar.
	 * Pre: la lista debe ser de apuestas validas.
	 * 
	 * @param itemsApuestas lista de itemapuesta a calcular
	 * @return monto total de la apuesta
	 */
	public int calcularMontoAApostar(List<ItemApuesta> itemsApuestas)
	{
		int calculoAApostar = 0;
		Casino cas = Casino.getInstance();
		for (ItemApuesta ia : itemsApuestas)
		{
			calculoAApostar += cas.getValores().get(ia.getFicha()) * ia.getCantidad();
		}
		return calculoAApostar;
	}
	
	public MSGReporteRankingJugadores reporteRanking(MSGReporteRankingJugadores msg)
	{	
		//TODO NO ORDENA
		MSGReporteRankingJugadores ranking = new MSGReporteRankingJugadores();
		List<MSGJugador> jugadoresOrdenados = new ArrayList<MSGJugador>();
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		
		List<Jugador> jugadoresParaOrdenar = new ArrayList<Jugador>();
		
		// ORDENAR LOS JUGADORES
		for(IJugador jug : manJug.getJugadores()){
			jugadoresParaOrdenar.add((Jugador)jug);
		}
		Collections.sort(jugadoresParaOrdenar);
		
		for(IJugador j : jugadoresParaOrdenar)
		{
			MSGJugador jmsg = new MSGJugador();
			jmsg.setNombre(j.getNombre());
			jmsg.setSaldo(j.getSaldo());
			jugadoresOrdenados.add(jmsg);
		}
		
		ranking.setAceptado(true);
		ranking.setDescripcion("El reporte del casino es:");
		ranking.setJugadores(jugadoresOrdenados);
		
		return ranking;
	}
	
	public MSGReporteEstadoActual reporteEstadoActual(MSGReporteEstadoActual msg)
	{
		if(!Casino.getInstance().isAbierto())
		{
			msg.setAceptado(false);
			msg.setDescripcion("El casino no esta abierto y no se han cargado los datos");
		}
		else
		{
			List<MSGJugador> jugadores = new ArrayList<MSGJugador>();
			ManejadorJugador manJug = ManejadorJugador.getInstance();
			for(IJugador jug : manJug.getJugadores())
			{
				if(jug.isLogeado())
				{
					MSGJugador jugad = new MSGJugador();
					jugad.setNombre(jug.getNombre());
					jugad.setSaldo(jug.getSaldo());
					jugadores.add(jugad);
				}
			}
			msg.setJugadores(jugadores);
			Casino cas = Casino.getInstance();
			MSGPozo pozo = new MSGPozo();
			pozo.setPozoFeliz(cas.getPozoFeliz());
			msg.setPozosCasino(pozo);
			msg.setSaldoCasino(cas.getSaldo());
			
			msg.setAceptado(true);
			msg.setDescripcion("El estado actual del casino es:");
		}
		return msg;
	}
	
}
