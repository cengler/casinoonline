package casino;

import casino.msg.MSGEntradaCasino;
import casino.msg.MSGSalidaCasino;

public interface IServiciosJugador {

	public abstract MSGEntradaCasino entrarCasino(MSGEntradaCasino mensaje);

	public abstract MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje);

}