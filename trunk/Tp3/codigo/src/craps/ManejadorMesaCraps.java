package craps;
import java.util.List;
import java.util.Observable;

import casino.IJugador;
import casino.IMesa;
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

	private static IServiciosCraps instance;
	private List<MesaCraps> mesas;
	private static String GAME_NAME = "craps";

	private ManejadorMesaCraps(){}

	public static IServiciosCraps getInstance(){
		if(instance == null)
			instance = new ManejadorMesaCraps();
		return instance;
	}
	
	// METODOS DE SERVICIOS EXTERNOS
	
	/**
	 * {@inheritDoc}
	 */
	public MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje){
//		 TODO
		return null;
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

	public int newIdMesa(){
		return 0;
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
