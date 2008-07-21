package craps;

import java.util.Observer;

import casino.IMesa;



/**
 * @version 1.0
 * @created 18-Jul-2008 19:48:48
 */
public class ManejadorObservadoresCraps implements IManejadorObservadoresCraps {

	private static ManejadorObservadoresCraps instance;
	public Observer observer;

	private ManejadorObservadoresCraps(){

	}

	public void agregarObservador(String idJugador, String idTVirt, IMesa mesa){

	}

	public static ManejadorObservadoresCraps getInstance(){
		if(instance == null)
			instance = new ManejadorObservadoresCraps();
		return instance;
	}

	/**
	 * 
	 * @param idJugador
	 * @param mesa
	 */
	public void quitarObservador(String idJugador, IMesa mesa){

	}

}