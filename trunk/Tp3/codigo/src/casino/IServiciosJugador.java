package casino;

import casino.msg.MSGEntradaCasino;
import casino.msg.MSGSalidaCasino;

public interface IServiciosJugador {

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public abstract MSGEntradaCasino entrarCasino(MSGEntradaCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public abstract MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje);

}