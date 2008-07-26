package casino;

import java.util.List;

/**
 * IMesa de casino onile.
 * 
 * @author Grupo2
 *
 */
public interface IMesa extends Comparable<IMesa>{

	boolean estaJugando(IJugador jugador);

	boolean isAbierta();

	int getId();

	List<IJugador> getJugadores();

	boolean tieneApuestasActivas(IJugador jug);	
	
}
