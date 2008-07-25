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

/**
 * ManejadorMesaCraps.
 * 
 * @author Grupo2
 *
 */
public class ManejadorMesaCraps extends ManejadorMesa implements IServiciosCraps {

	private Logger logger = Logger.getLogger(ManejadorMesaCraps.class);
	private static IServiciosCraps instance;
	private List<MesaCraps> mesas;
	private static String GAME_NAME = "craps";

	private ManejadorMesaCraps()
	{
		mesas = new ArrayList<MesaCraps>();
	}

	public static IServiciosCraps getInstance(){
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
					// AGREGO AL JUGADOR
					mesa.getJugadores().add(jug);
					
					// SETEO RESPUESTA
					mensaje.setAceptado(MSGEntradaCraps.SI);	
					mensaje.setDescripcion("El jugador ha sido ingresado a la mesa solicitada");
					logger.info("El jugador ha sido ingresado a la mesa solicitada");	
				}
			}
		}
		return mensaje;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MSGApuestaCraps apostarCraps(MSGApuestaCraps mensaje){
//		 TODO
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGTiroCraps tirarCraps(MSGTiroCraps unMSG){
//		 TODO
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje){
//		 TODO
		return null;
	}
	
	// METODOS DE MANEJADORE DE MESA

	/**
	 * {@inheritDoc}
	 */
	public boolean estaJugando(IJugador jugador) {
		
		boolean esta = false;
		int i = 0;
		
		while( i < getMesas().size() && !esta )
		
		for( IMesa m : getMesas() )
		{
			esta = m.getJugadores().contains(jugador);
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
