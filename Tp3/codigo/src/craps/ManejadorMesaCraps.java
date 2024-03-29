package craps;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import core.ImplementationFactory;

import casino.Casino;
import casino.IJugador;
import casino.IMesa;
import casino.ISeleccionadorTipoJugada;
import casino.ItemApuesta;
import casino.ManejadorCasino;
import casino.ManejadorDeSaldo;
import casino.ManejadorJugador;
import casino.ManejadorMesa;
import casino.SeleccionadorTipoJugadaPorModo;
import casino.msg.IMSGJuego;
import casino.msg.MSGCrapsEstado;
import casino.msg.MSGEstadoJugador;
import casino.msg.MSGMesaCraps;
import casino.msg.MSGProximoTiro;
import casino.msg.MSGUltimoTiroCraps;
import casino.msg.TipoJugada;
import craps.msg.MSGApostarCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGOpcionApuesta;
import craps.msg.MSGResultadoCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;
import craps.msg.MSGValorFicha;
import craps.msg.TipoApuestaCraps;

/**
 * ManejadorMesaCraps.
 * 
 * @author Grupo2
 * 
 */
public class ManejadorMesaCraps extends ManejadorMesa implements IServiciosCraps {

	private Logger logger = Logger.getLogger(ManejadorMesaCraps.class);
	private static ManejadorMesaCraps instance;
	private List<MesaCraps> mesas;
	private static String GAME_NAME = "craps";
	private IManejadorObservadoresCraps manejadorObs;

	private ManejadorMesaCraps() {
		mesas = new ArrayList<MesaCraps>();
		try 
		{
			manejadorObs = ImplementationFactory.getImplementation(IManejadorObservadoresCraps.class, true);
		} 
		catch (Exception e) 
		{
			logger.error("No se pudo obtener la implementacion de IManejadorObservadoresCraps", e);
		}
	}

	public static ManejadorMesaCraps getInstance() {
		if (instance == null)
			instance = new ManejadorMesaCraps();
		return instance;
	}

	public IMSGJuego estadoDeJuego() {
		MSGCrapsEstado mensaje = new MSGCrapsEstado();
		List<MSGMesaCraps> mesasCraps = new ArrayList<MSGMesaCraps>();

		// seteos de las mesas
		for (MesaCraps m : mesas) {
			MSGMesaCraps msgC = new MSGMesaCraps();
			// a MSGMesaCraps le seteo el id
			msgC.setId(m.getId());
			// seteo los jugadores de una mesa m
			List<MSGEstadoJugador> jugadores = new ArrayList<MSGEstadoJugador>();
			// una Mesa tiene IJugadores pero MSGMesaCraps tiene MSGJugador
			for (IJugador j : m.getJugadores()) {
				MSGEstadoJugador msgJug = new MSGEstadoJugador();
				msgJug.setNombre(j.getNombre());
				jugadores.add(msgJug);
			}
			msgC.setJugadores(jugadores);

			// seteo del proximo tiro de una mesa
			MSGProximoTiro proximoTiro = new MSGProximoTiro();
			proximoTiro.setTirador(m.getTirador().getNombre());
			if (m.isPuck() == true) // no es tiro de salida
				proximoTiro.setTiroSalida(MSGProximoTiro.NO);
			else
				proximoTiro.setTiroSalida(MSGProximoTiro.SI);
			proximoTiro.setPunto(m.getPunto());
			msgC.setProximoTiro(proximoTiro);

			// seteo del ultimoTiro
			MSGUltimoTiroCraps ultimoTiro = new MSGUltimoTiroCraps();
			if (m.getTiradorAnterior() != null)
				ultimoTiro.setTirador(m.getTiradorAnterior().getNombre());
			ultimoTiro.setResultado(m.getUltimoResultado());
			msgC.setUltimoTiro(ultimoTiro);
			mesasCraps.add(msgC);
		}
		mensaje.setMesasCraps(mesasCraps);
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje) {
		ManejadorJugador manJug = ManejadorJugador.getInstance();

		IJugador jug = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());

		if (!Casino.getInstance().isAbierto()) 
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El no esta abierto");
		} 
		else if (jug == null) {
			mensaje.setAceptado(MSGEntradaCraps.NO);
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugando en dicha terminal virtual");
		} else if (manJug.estaJugando(jug)) {
			mensaje.setAceptado(MSGEntradaCraps.NO);
			mensaje.setDescripcion("El jugador ya esta jugando en algun juego");
			logger.info("El jugador ya esta jugando en algun juego");
		} else {

			if (mensaje.getMesa() == 0) {
				/* HAY QUE CREAR UNA MESA */

				// CREO LA MESA
				MesaCraps mesa = new MesaCraps(newIdMesa());
				// AGREGO AL JUGADOR
				mesa.getJugadores().add(jug);
				// SET TIRADOR
				mesa.setTirador(jug);
				// ME GUARDO LA MESA PARA MANEJARLA
				mesas.add(mesa);

				// LO AGREGO COMO OBSERVADOR
				manejadorObs.agregarObservador(mensaje.getUsuario(), mensaje.getVTerm(), mesa);
				mesa.notifyObservers(new FotografiableCraps(mesa));

				
				// SETEO RESPUESTA
				mensaje.setAceptado(MSGEntradaCraps.SI);
				mensaje.setMesa(mesa.getId());
				mensaje.setDescripcion("El jugador ha sido ingresado a la mesa: " + mesa.getId() + " y es el tirador asignado");
				logger.info("El jugador ha sido ingresado a la mesa: " + mesa.getId() + " y es el tirador asignado");
			} else {
				logger.debug("Intentando unir al jugador a la mesa seleccionada");
				/* HAY QUE INTENTAR UNIRSE A UNA MESA */

				IMesa mesa = getMesa(mensaje.getMesa());
				if (mesa == null) {
					mensaje.setAceptado(MSGEntradaCraps.NO);
					mensaje.setDescripcion("La mesa a la cual se esta intentando unir no existe");
					logger.info("La mesa a la cual se esta intentando unir no existe");
				} else {
					if (mesa.isAbierta()) {
						// AGREGO AL JUGADOR
						mesa.getJugadores().add(jug);

						// LO AGREGO COMO OBSERVADOR
						manejadorObs.agregarObservador(mensaje.getUsuario(), mensaje.getVTerm(), (MesaCraps)mesa);
						((MesaCraps)mesa).notifyObservers(new FotografiableCraps((MesaCraps)mesa));
						
						// SETEO RESPUESTA
						mensaje.setAceptado(MSGEntradaCraps.SI);
						mensaje.setDescripcion("El jugador ha sido ingresado a la mesa solicitada");
						logger.info("El jugador ha sido ingresado a la mesa solicitada");
					} else {
						mensaje.setAceptado(MSGEntradaCraps.NO);
						mensaje.setDescripcion("La mesa a la que esta intentando unirse esta cerrada");
						logger.info("La mesa a la que esta intentando unirse esta cerrada");
					}
				}
			}
		}
		
		
		
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGApostarCraps apostarCraps(MSGApostarCraps mensaje)
	{	
		ManejadorCasino manCas = ManejadorCasino.getInstance();
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		IJugador jug = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());
		MesaCraps mesa = getMesa(mensaje.getMesa());
		boolean puck = false;
		if(mesa != null)
			mesa.isPuck();
		TipoApuestaCraps tipoApu = mensaje.getOpcionApuesta().getTipoApuesta();
		MSGOpcionApuesta opAp = mensaje.getOpcionApuesta();
		int puntaje = opAp.getPuntajeApostado();
		
		// LISTA DE VALORES DE FICHA APOSTADOS
		List<ItemApuesta> fichasAp = new ArrayList<ItemApuesta>();
		for (MSGValorFicha vf : mensaje.getValorApuesta()) {
			fichasAp.add(new ItemApuesta(vf.getValor(), vf.getCantidad()));
		}

		if (!Casino.getInstance().isAbierto()) 
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El no esta abierto");
		} 
		else if (jug == null) 
		{
			mensaje.setAceptado(MSGApostarCraps.NO);
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugando en dicha terminal virtual");
		} 
		else if (!estaJugando(jug))
		{
			mensaje.setAceptado(MSGApostarCraps.NO);
			mensaje.setDescripcion("El jugador no esta jugando en dicho juego");
			logger.info("El jugador no esta jugando en dicho juego");
		} 
		else if (mesa == null)
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("La mesa de la que esta intentando apostar no existe");
			logger.info("La mesa de la que esta intentando apostar no existe");
		} 
		else if (!mesa.estaJugando(jug))
		{
			mensaje.setAceptado(MSGApostarCraps.NO);
			mensaje.setDescripcion("El jugador no esta jugando en la mesa:" + getMesa(mensaje.getMesa()));
			logger.info("El jugador no esta jugando en la mesa:" + getMesa(mensaje.getMesa()));
		} 
		else if( !tipoApuestaValidaParaEstado(puck, tipoApu) )
		{
			mensaje.setAceptado(MSGApostarCraps.NO);
			mensaje.setDescripcion("La apuesta no es valida para el momento del juego");
			logger.info("La apuesta no es valida para el momento del juego");

		}
		else if ( !manCas.validarFichas(fichasAp) )
		{
			mensaje.setAceptado(MSGApostarCraps.NO);
			mensaje.setDescripcion("Las fichas a apostar no corresponden a fichas validas");
			logger.info("Las fichas a apostar no corresponden a fichas validas");
		}
		else if ( !manJug.montoValidoPara(jug, manCas.calcularMontoAApostar(fichasAp)) ) 
		{
			mensaje.setAceptado(MSGApostarCraps.NO);
			mensaje.setDescripcion("El jugador no posee fondos para dicha apuesta");
			logger.info("El jugador no posee fondos para dicha apuesta");
		}
		else
		{
			int montoAp = manCas.calcularMontoAApostar(fichasAp);
			ManejadorDeApuestas manApCr = mesa.getPagador();
			
			try {
				manApCr.crearNuevaApuesta(jug, puntaje, tipoApu, montoAp, fichasAp);
			} catch (CrapsException e) {
				logger.error(e.getMessage());
				mensaje.setAceptado(MSGApostarCraps.NO);
				mensaje.setDescripcion(e.getMessage());
				return mensaje;
			}
			
			ManejadorDeSaldo.getInstance().transferirJugadorACasino(jug, montoAp);

			// NOTIFICO A TODOS LOS OBSERVADORES
			mesa.notifyObservers(new FotografiableCraps(mesa));
			
			mensaje.setAceptado(MSGApostarCraps.SI);
			mensaje.setDescripcion("El jugador ha realizado una apuesta de tipo: " + tipoApu.name() + " y ha apostado:" + montoAp);
			logger.info("El jugador ha realizado una apuesta de tipo: " + tipoApu.name() + " y ha apostado:" + montoAp);
		}
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGTiroCraps tirarCraps(MSGTiroCraps unMSG) {

		ManejadorJugador manJug = ManejadorJugador.getInstance();
		IJugador jug = manJug.getJugadorLoggeado(unMSG.getUsuario(), unMSG.getVTerm());

		if (!Casino.getInstance().isAbierto()) 
		{
			unMSG.setAceptado(MSGSalidaCraps.NO);
			unMSG.setDescripcion("El no esta abierto");
		} 
		else if (jug == null) {
			unMSG.setAceptado(MSGTiroCraps.NO);
			unMSG.setDescripcion("El jugador no esta loggeado como jugador en dicha terminal virtual");
			logger.info("El jugador no esta loggeado como jugador en dicha terminal virtual");
		} else // EL JUGADOR ESTA LOGEADO
		{
			int mesa = unMSG.getMesa();
			MesaCraps laMesa = this.getMesa(mesa);

			if (laMesa == null || !laMesa.estaJugando(jug)) // EL JUGADOR NO
			// ESTA JUGANDO EN
			// EL JUEGO
			{
				unMSG.setAceptado(MSGTiroCraps.NO);
				unMSG.setDescripcion("El jugador no esta jugando en el juego");
				logger.info("El jugador no esta jugando en el juego");
			} else // EL JUGADOR ESTA JUGANDO EN LA MESA???
			{
				if (!getMesa(unMSG.getMesa()).getJugadores().contains(jug)) {

					unMSG.setAceptado(MSGApostarCraps.NO);
					unMSG.setDescripcion("El jugador no esta jugando en la mesa:" + getMesa(unMSG.getMesa()));
					logger.info("El jugador no esta jugando en la mesa:" + getMesa(unMSG.getMesa()));

				} else {

					if (!(laMesa.getTirador().equals(jug))) {
						unMSG.setAceptado(MSGTiroCraps.NO);
						unMSG.setDescripcion("El jugador no el el tirador asignado, lo es: " + laMesa.getTirador().getNombre());
						logger.info("El jugador no el el tirador asignado, lo es: " + laMesa.getTirador().getNombre());
					} else // EL JUGADOR ES EL TIRADOR DE LA MESA
					{
						laMesa.setTiradorAnterior(jug);
						laMesa.sigJugada();
						
						// BUSCO TIPO DE JUGADA
						ISeleccionadorTipoJugada s = SeleccionadorTipoJugadaPorModo.getInstance();
						TipoJugada jugada = s.getTipoJugada(laMesa);

						// BUSCO RESULTADO
						ISeleccionadorResCraps src = SeleccionadorResCrapsPorModo.getInstance();
						ResultadoCraps resultado = src.getResult();
						laMesa.setUltimoResultado(resultado.getDado1()+resultado.getDado2());

						// PAGO APUESTAS
						laMesa.getPagador().pagarApuestas(jugada, resultado, laMesa.isPuck(), laMesa.getIdJugada());
						laMesa.getPagador().modificarApuestas(resultado, laMesa.isPuck());

						// DEFINO DESITNO DE JUGADOR Y SELECCIONO PROXIMO
						// TIRADOR Y MODIFICO PUCK
						boolean sigueTirando = true;

						if (!laMesa.isPuck()) // PUCK APAGADO == TIRO DE
						// SALIDA
						{

							if (laMesa.saleCraps(resultado)) // PERDIO!
							{
								ISeleccionadorDeTirador selTir = SeleccionadorDeTiradorEnOrden.getInstance();
								IJugador proxTirador = selTir.getProxTirador(laMesa);
								laMesa.setTirador(proxTirador);
								sigueTirando = false;
							} else // NO PERDIO!
							{
								if (laMesa.saleNatural(resultado)) // GANO!
								{
									// NADA VER
								} else // ESTABLECE PUNTO !!!! OJO
								{
									laMesa.setPuck(true);
									laMesa.setPunto(resultado);

								}
							}
						} else // PUCK PRENDIDO == NO TIRO DE SALIDA
						{
							if (laMesa.salioSiete(resultado)) // PERDIO!
							{
								ISeleccionadorDeTirador selTir = SeleccionadorDeTiradorEnOrden.getInstance();
								IJugador proxTirador = selTir.getProxTirador(laMesa);
								laMesa.setTirador(proxTirador);
								laMesa.setPuck(false);
								sigueTirando = false;
								laMesa.setPunto(0);
							} else // NO PERDIO!
							{
								if (laMesa.repitioPunto(resultado, laMesa.getPunto())) // GANO!
								{
									laMesa.setPuck(false);
									laMesa.setPunto(0);
								} else // SIGUE INTENTANDO REPETIR PUNTO
								{
									// TODO que se hace en este caso? NADA?
								}
							}
						}

						// NOTIFICO A TODOS LOS OBSERVADORES
						laMesa.notifyObservers(new FotografiableCraps(laMesa));
						
						// SETEO MENSAJE DE RTA
						unMSG.setAceptado(MSGTiroCraps.SI);
						unMSG.setTipoJugada(jugada);
						MSGResultadoCraps resCraps = new MSGResultadoCraps();
						resCraps.setDado1(resultado.getDado1());
						resCraps.setDado2(resultado.getDado2());
						unMSG.setResultado(resCraps);

						if (sigueTirando) {
							unMSG.setDescripcion("El jugador ha tirado los dados y sigue tirando");
							logger.info("El jugador ha tirado los dados y sigue tirando. Puck: " + laMesa.isPuck());
						} else {
							unMSG.setDescripcion("El jugador ha tirado los dados y NO sigue tirando Puck: " + laMesa.isPuck());
							logger.info("El jugador ha tirado los dados y NO sigue tirando Puck: " + laMesa.isPuck());
						}
					}
				}
			}
		}

		return unMSG;

	}

	/*
	 * VER QUE AL SALIR EL TIRADOR SE PROPONGA OTRO O SE CIERRE LA MESA TODO
	 */
	/**
	 * {@inheritDoc}
	 */
	public MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje) {
		ManejadorJugador manJug = ManejadorJugador.getInstance();

		IJugador jug = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());
		MesaCraps mesa = getMesa(mensaje.getMesa());

		if (!Casino.getInstance().isAbierto()) 
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El no esta abierto");
		} 
		else if (jug == null) 
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
		} 
		else if (!estaJugando(jug)) 
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador no esta jugando en dicho juego");
		} 
		else if ( mesa == null)
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("La mesa de la que esta intentando retirarse no existe");
			logger.info("La mesa de la que esta intentando retirarse no existe");
		} 
		else if ( !mesa.getJugadores().contains(jug))
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador no se encuentra en la mesa de la que esta intentando retirarse");
			logger.info("El jugador no se encuentra en la mesa de la que esta intentando retirarse");
		}
		else if (mesa.tieneApuestasActivas(jug)) 
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador tiene apuestas activas no puede retirarse");
			logger.info("El jugador tiene apuestas activas no puede retirarse");
		} 
		else
		{
			if (mesa.getJugadores().size() == 1) {
				// SE DEBE CERRAR LA MESA
				mesa.setAbierta(false);
			}
			if(mesa.getTirador().equals(jug))
			{
				ISeleccionadorDeTirador selTir = SeleccionadorDeTiradorEnOrden.getInstance();
				mesa.setTiradorAnterior(mesa.getTirador());
				IJugador proxTirador = selTir.getProxTirador(mesa);
				mesa.setTirador(proxTirador);
			}
			mesa.getJugadores().remove(jug);

			// QUITO AL JUGADOR COMO OBSERVADOR
			manejadorObs.quitarObservador(mensaje.getUsuario(), (MesaCraps)mesa);
			mesa.notifyObservers(new FotografiableCraps(mesa));
			
			// SETEO RESPUESTA
			mensaje.setAceptado(MSGSalidaCraps.SI);
			mensaje.setDescripcion("El jugador se ha retirado correctament de la mesa");
			logger.info("El jugador se ha retirado correctament de la mesa");
		}
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean estaJugando(IJugador jugador) {

		boolean esta = false;
		int i = 0;

		while (i < getMesas().size() && !esta) {
			esta = getMesas().get(i).getJugadores().contains(jugador);
			i++;
		}
		return esta;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean mesasCerradas() {

		boolean mesasCer = true;
		for (IMesa m : getMesas()) {
			mesasCer = mesasCer && !m.isAbierta();
		}
		return mesasCer;
	}

	// GETER Y SETERS

	/**
	 * Get mesas.
	 * 
	 * @return mesas del manejador
	 */
	public List<MesaCraps> getMesas() {
		return mesas;
	}

	/**
	 * Set mesas.
	 * 
	 * @param mesas mesas a setear.
	 */

	public void setMesas(List<MesaCraps> mesas) {
		this.mesas = mesas;
	}

	public boolean saleNatural(int dado, int dado2) {
		return false;
	}

	public MesaCraps getMesa(int id) {
		for (MesaCraps m : mesas) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	public String getName() {
		return GAME_NAME;
	}
	
	private static boolean tipoApuestaValidaParaEstado(boolean puck, TipoApuestaCraps tipoApu)
	{
		boolean res = true;
		if(puck)
			res = !tipoApu.equals(TipoApuestaCraps.pase) && !tipoApu.equals(TipoApuestaCraps.nopase);
		else
			res = !tipoApu.equals(TipoApuestaCraps.venir) && !tipoApu.equals(TipoApuestaCraps.novenir);
		return res;
	}
}
