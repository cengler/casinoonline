package craps;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import casino.IJugador;
import casino.IMesa;
import casino.ISeleccionadorTipoJugada;
import casino.ManejadorJugador;
import casino.ManejadorMesa;
import casino.SeleccionadorTipoJugadaPorModo;
import casino.TipoJugada;
import craps.msg.MSGApostarCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGResultadoCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;
import craps.msg.MSGOpcionApuesta;

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

	private ManejadorMesaCraps()
	{
		mesas = new ArrayList<MesaCraps>();
	}

	public static ManejadorMesaCraps getInstance(){
		if(instance == null)
			instance = new ManejadorMesaCraps();
		return instance;
	}
	
	// METODOS DE SERVICIOS EXTERNOS
	
	/**
	 * {@inheritDoc}
	 */
	public MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje)
	{
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		manJug.getManejadores().add((ManejadorMesaCraps)ManejadorMesaCraps.getInstance());
		
		IJugador jug = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());
		
		if(jug == null)
		{
			mensaje.setAceptado(MSGEntradaCraps.NO);
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugando en dicha terminal virtual");
		}
		else if(manJug.estaJugando(jug))
		{
			mensaje.setAceptado(MSGEntradaCraps.NO);
			mensaje.setDescripcion("El jugador ya esta jugando en algun juego");
			logger.info("El jugador ya esta jugando en algun juego");
		}
		else
		{
			
			if(mensaje.getMesa() == 0)
			{
				/*HAY QUE CREAR UNA MESA*/
				
				// CREO LA MESA
				MesaCraps mesa = new MesaCraps(newIdMesa());
				// AGREGO AL JUGADOR
				mesa.getJugadores().add(jug);
				// SET TIRADOR
				mesa.setTirador(jug);
				
				// ME GUARDO LA MESA PARA MANEJARLA
				mesas.add(mesa);
				
				// SETEO RESPUESTA
				mensaje.setAceptado(MSGEntradaCraps.SI);
				mensaje.setMesa(mesa.getId());		
				mensaje.setDescripcion("El jugador ha sido ingresado a la mesa: " + mesa.getId() + " y es el tirador asignado");
				logger.info("El jugador ha sido ingresado a la mesa: " + mesa.getId() + " y es el tirador asignado");	
			}
			else
			{
				logger.debug("Intentando unir al jugador a la mesa seleccionada");
				/*HAY QUE INTENTAR UNIRSE A UNA MESA*/
				
				IMesa mesa = getMesa(mensaje.getMesa());
				if(mesa == null)
				{
					mensaje.setAceptado(MSGEntradaCraps.NO);
					mensaje.setDescripcion("La mesa a la cual se esta intentando unir no existe");
					logger.info("La mesa a la cual se esta intentando unir no existe");
				}
				else
				{
					if(mesa.isAbierta())
					{	
						// AGREGO AL JUGADOR
						mesa.getJugadores().add(jug);
						
						// SETEO RESPUESTA
						mensaje.setAceptado(MSGEntradaCraps.SI);	
						mensaje.setDescripcion("El jugador ha sido ingresado a la mesa solicitada");
						logger.info("El jugador ha sido ingresado a la mesa solicitada");
					}	
					else
					{
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
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		
		IJugador jug = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());

		if(jug == null)
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugando en dicha terminal virtual");
		}
		else if(!estaJugando(jug))
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador no esta jugando en dicho juego");
			logger.info("El jugador no esta jugando en dicho juego");
		}
		else if( getMesa(mensaje.getMesa()) == null )
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("La mesa de la que esta intentando apostar no existe");
			logger.info("La mesa de la que esta intentando apostar no existe");
		}
		else
		{
			MesaCraps mesa = getMesa(mensaje.getMesa());
			
			
			//VALIDO FICHAS y si son validas calculo el monto a apostar
			int calculoAApostar = 0;
			int i = 0;
			boolean fichaValida = true;
			while (i < (mensaje.getValorApuesta()).size() || fichaValida == true){

				//MSGValorFicha vf = (mensaje.getValorApuesta()).first();
				//if(el valor de la ficha es valido){
	//			 calculoAApostar = calculoAApostar + (vf.getCantidad()* vf.getValor);
				i++;
				/*}else{
				  	fichaValida = false;
	  	
					
				}*/
			}
			if (fichaValida == false){
				
				mensaje.setAceptado(MSGApostarCraps.NO);
				mensaje.setDescripcion("Las fichas a apostar no corresponden a fichas validas");
				logger.info("Las fichas a apostar no corresponden a fichas validas");
			}else{
				
				IJugador jugador = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());
				boolean montoValido = manJug.montoValidoPara(jugador,calculoAApostar);
				if (montoValido == true){
					
					MSGOpcionApuesta opAp = mensaje.getOpcionApuesta();
					String tipoAp = opAp.getTipoApuesta();
					int puntaje = opAp.getPuntajeApostado();
					ApuestaCraps apCr = new ApuestaCraps(jugador, puntaje, tipoAp, calculoAApostar);
					mesa.getPagador().getApuestas().add(apCr);
					manJug.debitarMonto(jugador, calculoAApostar);
					
					mensaje.setAceptado(MSGApostarCraps.SI);
					mensaje.setDescripcion("El jugador ha realizado una apuesta de tipo:" +tipoAp + "y ha apostado:" + calculoAApostar );
					logger.info("El jugador ha realizado una apuesta de tipo:" +tipoAp + "y ha apostado:" + calculoAApostar );

					
				}
			}
			
		}
		
				
		return mensaje;
	}	/**
	 * {@inheritDoc}
	 */
	public MSGTiroCraps tirarCraps(MSGTiroCraps unMSG){

		ManejadorJugador manJug = ManejadorJugador.getInstance();
		IJugador jug = manJug.getJugadorLoggeado(unMSG.getUsuario(), unMSG.getVTerm());
		
		if(jug == null)
		{
			unMSG.setAceptado(MSGEntradaCraps.NO);
			unMSG.setDescripcion("El jugador no esta registrado como jugador en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugador en dicha terminal virtual");
		}
		else // EL JUGADOR ESTA LOGEADO
		{
			int mesa = unMSG.getMesa(); 
			MesaCraps laMesa = this.getMesa(mesa);
						
			if( laMesa == null || !laMesa.estaJugando(jug)) // EL JUGADOR NO ESTA JUGANDO EL LA MESA
			{	
				unMSG.setAceptado(MSGTiroCraps.NO);
				unMSG.setDescripcion("El jugador no esta jugando en la mesa: " + unMSG.getMesa());
				logger.info("El jugador no esta jugando en la mesa: " + unMSG.getMesa());				
			}
			else // EL JUGADOR ESTA JUGANDO EN LA MESA
			{
				if ( !(laMesa.getTirador().equals(jug)) )
				{
					unMSG.setAceptado(MSGTiroCraps.NO);
					unMSG.setDescripcion("El jugador no el el tirador asignado, lo es: " + laMesa.getTirador().getNombre());
					logger.info("El jugador no el el tirador asignado, lo es: " + laMesa.getTirador().getNombre());	
				}	
				else // EL JUGADOR ES EL TIRADOR DE LA MESA
				{	
					// BUSCO TIPO DE JUGADA
					ISeleccionadorTipoJugada s = SeleccionadorTipoJugadaPorModo.getInstance();
					TipoJugada jugada = s.getTipoJugada(laMesa);
					
					// BUSCO RESULTADO
					ISeleccionadorResCraps src = SeleccionadorResCrapsPorModo.getInstance();
					ResultadoCraps resultado = src.getResult();
					boolean sigueTirando = true;
					
					if ( !laMesa.isPuck() ) // PUCK APAGADO == TIRO DE SALIDA
					{
						
						if (laMesa.saleCraps(resultado)) // PERDIO!
						{ 
							ISeleccionadorDeTirador selTir = SeleccionadorDeTiradorEnOrden.getInstance();
							IJugador proxTirador = selTir.getProxTirador(laMesa);
							laMesa.setTirador(proxTirador);
							sigueTirando = false;
						}
						else // NO PERDIO!
						{
							if (laMesa.saleNatural(resultado)) // GANO!
							{
								// NADA VER
							}
							else // ESTABLECE PUNTO !!!! OJO
							{
								laMesa.setPuck(true);
								laMesa.setPunto(resultado);
								// TODO que se hace en este caso? NADA?
							}
						}	
					}
					else // PUCK PRENDIDO == NO TIRO DE SALIDA
					{
						if(laMesa.salioSiete(resultado)) // PERDIO!
						{
							ISeleccionadorDeTirador selTir = SeleccionadorDeTiradorEnOrden.getInstance();
							IJugador proxTirador = selTir.getProxTirador(laMesa);
							laMesa.setTirador(proxTirador);	
							laMesa.setPuck(false);
							sigueTirando = false;
						}
						else // NO PERDIO!
						{
							if(laMesa.repitioPunto(resultado, laMesa.getPunto())) // GANO!
							{
								laMesa.setPuck(false);
							}
							else // SIGUE INTENTANDO REPETIR PUNTO
							{
								//	TODO que se hace en este caso? NADA?
							}
						}			
					}
					
					unMSG.setAceptado(MSGTiroCraps.SI);	
					unMSG.setTipoJugada(jugada);
					MSGResultadoCraps resCraps = new MSGResultadoCraps();
					resCraps.setDado1(resultado.getDado1());
					resCraps.setDado2(resultado.getDado2());
					unMSG.setResultado(resCraps);
					
					if(sigueTirando)
					{
						unMSG.setDescripcion("El jugador ha tirado los dados y sigue tirando");
						logger.info("El jugador ha tirado los dados y sigue tirando. Puck: " + laMesa.isPuck());
					}
					else
					{
						unMSG.setDescripcion("El jugador ha tirado los dados y NO sigue tirando" + laMesa.isPuck());
						logger.info("El jugador ha tirado los dados y NO sigue tirando Puck: " + laMesa.isPuck());
					}
					
					// NO PARECE QUE SEA EL MENSAJE EL QUE PAGA
					//laMesa.getPagador().pagarApuestas();
					//unMSG.pagarApuestas(jugada, resultado, laMesa.getId()); TODO
					laMesa.notifyObservers();
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
	public MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje)
	{
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		
		IJugador jug = manJug.getJugadorLoggeado(mensaje.getUsuario(), mensaje.getVTerm());

		if(jug == null)
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador no esta registrado como jugando en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugando en dicha terminal virtual");
		}
		else if(!estaJugando(jug))
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("El jugador no esta jugando en dicho juego");
			logger.info("El jugador no esta jugando en dicho juego");
		}
		else if( getMesa(mensaje.getMesa()) == null )
		{
			mensaje.setAceptado(MSGSalidaCraps.NO);
			mensaje.setDescripcion("La mesa de la que esta intentando retirarse no existe");
			logger.info("La mesa de la que esta intentando retirarse no existe");
		}
		else
		{
			MesaCraps mesa = getMesa(mensaje.getMesa());
			
			/* INTENTO QUITAR AL JUGADOR */
			if(mesa.getJugadores().contains(jug))
			{
				if( mesa.tieneApuestasActivas(jug) )
				{
					mensaje.setAceptado(MSGSalidaCraps.NO);
					mensaje.setDescripcion("El jugador tiene apuestas activas no puede retirarse");
					logger.info("El jugador tiene apuestas activas no puede retirarse");
				}
				else
				{
					if(mesa.getJugadores().size() == 1)
					{
						// SE DEBE CERRAR LA MESA
						mesa.setAbierta(false);
					}
					mesa.getJugadores().remove(jug);
					
					mensaje.setAceptado(MSGSalidaCraps.NO);
					mensaje.setDescripcion("El jugador se ha retirado correctament de la mesa");
					logger.info("El jugador se ha retirado correctament de la mesa");
				}	
			}
			else
			{
				mensaje.setAceptado(MSGSalidaCraps.NO);
				mensaje.setDescripcion("El jugador no se encuentra en la mesa de la que esta intentando retirarse");
				logger.info("El jugador no se encuentra en la mesa de la que esta intentando retirarse");
			}
		}
		return mensaje;
	}
	
	// METODOS DE MANEJADORE DE MESA

	/**
	 * {@inheritDoc}
	 */
	public boolean estaJugando(IJugador jugador) {
		
		boolean esta = false;
		int i = 0;
		
		while( i < getMesas().size() && !esta )
		{
			getMesas().get(i).getJugadores().contains(jugador);
			i++;
		}
		return esta;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean mesasCerradas() {
		
		boolean mesasCer = true;
		for ( IMesa m : getMesas() )
		{
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
	
	// METODOS INTERNOS
	
	
	public void agregarObservador(String idJugador, String idTVirt, Observable mesa){

	}

	

	
	
	
	

	public List<MesaCraps> getMesasAbiertas(){
		return null;
	}

	public void quitarObservador(String idJugador, IMesa mesa){

	}

	/*public void repitioPunto(int a, <int, int> b){

	}*/

	/**
	 * 
	 * @param dado
	 * @param dado2
	 */
	public boolean saleCraps(int dado, int dado2){
		return false;
	}

	/**
	 * 
	 * @param dado
	 * @param dado2
	 */
	public boolean saleNatural(int dado, int dado2){
		return false;
	}

	public MesaCraps getMesa(int id)
	{
		for(MesaCraps m : mesas)
		{
			if(m.getId() == id)
			{
				return m;
			}
		}
		return null;
	}

	public String getName() {
		return GAME_NAME;
	}
	
	

}
