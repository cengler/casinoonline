package craps;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import casino.IJugador;
import casino.IMesa;
import casino.ManejadorJugador;
import casino.ManejadorMesa;
import craps.msg.MSGApuestaCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;
import craps.msg.MSGResultadoCraps;
import casino.ISeleccionadorTipoJugada;
import casino.SeleccionadorTipoJugadaPorModo;
import casino.TipoJugada;

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
	public MSGApuestaCraps apostarCraps(MSGApuestaCraps mensaje)
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
			
			mesa.getId();
			//VALIDO FICHAS
			
			
			
		}
		
		//TODO
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGTiroCraps tirarCraps(MSGTiroCraps unMSG){

		ManejadorJugador manJug = ManejadorJugador.getInstance();
		manJug.getManejadores().add((ManejadorMesaCraps)ManejadorMesaCraps.getInstance());
		
		IJugador jug = manJug.getJugadorLoggeado(unMSG.getUsuario(), unMSG.getVTerm());
		
		if(jug == null)
		{
			unMSG.setAceptado(MSGEntradaCraps.NO);
			unMSG.setDescripcion("El jugador no esta registrado como jugador en dicha terminal virtual");
			logger.info("El jugador no esta registrado como jugador en dicha terminal virtual");
		}
		else
		{
			int mesa = unMSG.getMesa(); 
			MesaCraps laMesa = this.getMesa(mesa);
						
			if(mesa == 0 || laMesa.estaJugando(jug)){
//				 SETEO RESPUESTA
				unMSG.setAceptado(MSGTiroCraps.NO);
				unMSG.setDescripcion("El jugador no esta jugando en la mesa ");
				logger.info("El jugador no esta jugando en la mesa ");	
							
			}else{
			
				if (laMesa.getTirador()== jug ){
									
						ISeleccionadorTipoJugada s = SeleccionadorTipoJugadaPorModo.getInstance();
						TipoJugada jugada = s.getTipoJugada(laMesa);
						
						laMesa.notifyObservers();
						ISeleccionadorResCraps src = SeleccionadorResCrapsPorModo.getInstance();
						
						//falta implementar el metodo getInstance()	
						ResultadoCraps resultado = src.getResult();
						//falta el metodo getResult de seleccionadorResCrapsPorModo
		
						
						if (laMesa.isPuck()== false){
							//el puck esta apagado, es tiro de salida
							
											
							if (laMesa.saleCraps(resultado)){ //falta el metodo saleCraps(int)
								
								ISeleccionadorDeTirador selTir = SeleccionadorDeTiradorEnOrden.getInstance();
								//falta metodo getInstance()
								IJugador proxTirador = selTir.getProxTirador(laMesa);
								//falta getProxTirador quien deberia tener como parametro la mesa
								laMesa.notifyObservers();
								laMesa.setTirador(proxTirador);
							}else{		
								
								if (laMesa.saleNatural(resultado)){//falta el metodo saleNatural(int)
									
									laMesa.setPunto(resultado);
									laMesa.setPuck(true);
									laMesa.notifyObservers();
									
								}
							}
							
						}else{
							//el puck esta prendido
							int punto = laMesa.getPunto();
							if(laMesa.salioSiete(resultado, punto)){
								ISeleccionadorDeTirador selTir = SeleccionadorDeTiradorEnOrden.getInstance();
								//falta metodo getInstance()
								IJugador proxTirador = selTir.getProxTirador(laMesa);
								//falta getProxTirador quien deberia tener como parametro la mesa
								laMesa.notifyObservers();
								laMesa.setTirador(proxTirador);
								
							}else{
								if(laMesa.repitioPunto(resultado, punto)){
									//apago el puck
									laMesa.setPuck(false);
								}
								
							}
													
						}
						
						
						unMSG.setAceptado(MSGTiroCraps.SI);	
						unMSG.setTipoJugada(jugada);
						MSGResultadoCraps resCraps = new MSGResultadoCraps();
						resCraps.setDado1(resultado.getDado1());
						resCraps.setDado2(resultado.getDado2());
						unMSG.setResultado(resCraps);
						unMSG.pagarApuestas(jugada, resultado, laMesa.getId());
						unMSG.setDescripcion("El jugador ha tirado los dados");
						logger.info("El jugador ha sido ingresado a la mesa solicitada");
						
					}else{
						
						unMSG.setAceptado(MSGTiroCraps.NO);
						unMSG.setDescripcion("al jugador no le toca tirar ");
						logger.info("al jugador no le toca tirar ");	
						
						
					}
				
				}
								
			}	
				
			
					
		return unMSG;

	}
	
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
