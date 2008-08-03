package observerCraps;

import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import craps.IManejadorObservadoresCraps;

/**
 * ManejadorObservadoresCraps. Clase encargada de manejar la registracion 
 * y desregistracion de observadores de craps
 * 
 * @author Grupo2
 *
 */
public class ManejadorObservadoresCraps implements IManejadorObservadoresCraps {

	private static Logger logger = Logger.getLogger(ManejadorObservadoresCraps.class);
	private static ManejadorObservadoresCraps instance;
	private List<ObservadorCraps> observers;

	/**
	 * Constructor privado.
	 */
	private ManejadorObservadoresCraps(){}

	/**
	 * {@inheritDoc}
	 */
	public void agregarObservador(String idJugador, String idTVirt, Observable mesa)
	{
		ObservadorCraps obs = new ObservadorCraps();
		obs.setMesa(mesa);
		obs.setIdJugador(idJugador);
		obs.setIdTVirt(idTVirt);
		mesa.addObserver(obs);
		
		logger.info("Agregado Observador " + idJugador + " con idVirt: " + idTVirt);
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
	public void quitarObservador(String idJugador, Observable mesa)
	{
		ObservadorCraps observerSel = null;
		
		for (ObservadorCraps o : observers)
		{
			if(o.getIdJugador().equals(idJugador))
			{
				observerSel = o;
			}
		}
		
		if(observerSel == null)
		{
			mesa.deleteObserver(observerSel);
			observers.remove(observerSel);
		}
		else
		{
			logger.error("No existe observador asociado al jugador dado");
			// TODO
		}
	}
}
