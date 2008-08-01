package casino;

import java.util.List;

import casino.msg.estadoCasino.IMSGJuego;

/**
 * ManejadorMesa
 * 
 * @author Administrador
 *
 */
public abstract class ManejadorMesa
{
	
	private int lastIdMesa = 0;
	
	/**
	 * Informa su el jugador esta jugando en ese manejador en particular.
	 * 
	 * @param jugador jugador que esta potencialmente jugando
	 * @return true si el jugador esta jugando en ese manejador
	 */
	public abstract List<?> getMesas();
	
	
	public abstract boolean estaJugando(IJugador jugador);
	
	/**
	 * Informa si todas las mesas del manejador estan cerradas.
	 * 
	 * @return true si no hay ninguna mesa abierta
	 */
	public abstract boolean mesasCerradas();
	
	public abstract String getName();

	public abstract IMSGJuego estadoDeJuego();
	
	public abstract IMesa getMesa(int id);
	
	/**
	 * Obtiene los id para las mesas de todos los juegos. 
	 * De tal manera, no habra en el casino dos mesas con el mismo id
	 * 
	 * @return el siguiente id generado
	 */
	protected synchronized int newIdMesa()
	{
		lastIdMesa++;
		return lastIdMesa;	
	}
	
	
}
