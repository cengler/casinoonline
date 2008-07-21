package craps;

import casino.IMesa;

public interface IManejadorObservadoresCraps {

	/**
	 * 
	 * @param idJugador
	 * @param idTVirt
	 * @param mesa
	 */
	public void agregarObservador(String idJugador, String idTVirt, IMesa mesa);

	/**
	 * 
	 * @param idJugador
	 * @param mesa
	 */
	public void quitarObservador(String idJugador, IMesa mesa);

}