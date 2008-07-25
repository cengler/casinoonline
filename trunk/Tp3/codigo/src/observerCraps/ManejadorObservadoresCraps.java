package observerCraps;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import craps.IManejadorObservadoresCraps;

/**
 * ManejadorObservadoresCraps. Clase encargada de manejar la registracion 
 * y desregistracion de observadores de craps
 * 
 * @author Grupo2
 *
 */
public class ManejadorObservadoresCraps implements IManejadorObservadoresCraps {

	private static ManejadorObservadoresCraps instance;
	private List<ObservadorCraps> observers;

	/**
	 * Constructor privado.
	 */
	private ManejadorObservadoresCraps(){}

	/**
	 * {@inheritDoc}
	 */
	public void agregarObservador(String idJugador, int idTVirt, Observable mesa){
		
		ObservadorCraps obs = new ObservadorCraps();
		obs.setMesa(mesa);
		obs.setIdJugador(idJugador);
		obs.setIdTVirt(idTVirt);
		observers.add(obs);
	}

	/**
	 * Obtiene la unica instancia del ManejadorObservadoresCraps.
	 * @return
	 */
	public static ManejadorObservadoresCraps getInstance(){
		if(instance == null)
			instance = new ManejadorObservadoresCraps();
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	public void quitarObservador(String idJugador, ObservadorCraps mesa)
	{
		ObservadorCraps observerSel;
		
		for (ObservadorCraps o : observers)
		{
			if(o.getIdJugador().equals(mesa.getIdJugador()))
			{
				observerSel = o;
			}
		}
		//observers.remove(()o);
		//TODO
	}

	public void agregarObservador(String idJugador, String idTVirt, Observable mesa) {
		// TODO Auto-generated method stub
		
	}

	public void quitarObservador(String idJugador, Observable mesa) {
		// TODO Auto-generated method stub
		
	}

	
}
