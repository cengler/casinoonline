package casino;

import java.util.List;

/**
 * IMesa de casino onile.
 * 
 * @author Grupo2
 *
 */
public interface IMesa extends Comparable<IMesa>{

	public boolean estaJugando(IJugador jugador);

	public boolean isAbierta();

	public int getId();

	public List<IJugador> getJugadores();

	/**
	 * 
	 * @param abierta
	 */
	public void setAbierta(boolean abierta);
}
