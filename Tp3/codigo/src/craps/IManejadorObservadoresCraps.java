package craps;

import java.util.Observable;

/**
 * Interface IManejadorObservadoresCraps.
 
 * @author Grupo2
 *
 */
public interface IManejadorObservadoresCraps {

	void agregarObservador(String idJugador, String idTVirt, Observable mesa);

	void quitarObservador(String idJugador, Observable mesa);

}