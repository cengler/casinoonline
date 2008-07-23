package casino;

/**
 * ManejadorMesa
 * 
 * @author Administrador
 *
 */
public abstract class ManejadorMesa
{
	/**
	 * Informa su el jugador esta jugando en ese manejador en particular.
	 * 
	 * @param jugador jugador que esta potencialmente jugando
	 * @return true si el jugador esta jugando en ese manejador
	 */
	public abstract boolean estaJugando(IJugador jugador);
	
	/**
	 * Informa si todas las mesas del manejador estan cerradas.
	 * 
	 * @return true si no hay ninguna mesa abierta
	 */
	public abstract boolean mesasCerradas();
	
}
