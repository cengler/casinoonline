package casino;

import casino.msg.MSGEntradaCasino;
import casino.msg.MSGSalidaCasino;

public interface IServiciosJugador {

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGEntradaCasino entrarCasino(MSGEntradaCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje);

}