package craps;

import java.util.Observable;

/**
 * Interface IManejadorObservadoresCraps.
 * @author Administrador
 *
 */
public interface IManejadorObservadoresCraps {

	public void agregarObservador(String idJugador, String idTVirt, Observable mesa);

	public void quitarObservador(String idJugador, Observable mesa);

}