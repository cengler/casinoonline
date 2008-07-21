package casino;

import java.util.List;

public interface IMesa {

	public boolean estaJugando(IJugador jugador);

	public boolean getAbierta();

	public int getId();

	public List<IJugador> getJugadores();

	/**
	 * 
	 * @param abierta
	 */
	public void setAbierta(boolean abierta);
}