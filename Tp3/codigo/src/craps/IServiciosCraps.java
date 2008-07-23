package craps;

import craps.msg.MSGApuestaCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;

public interface IServiciosCraps {

	public abstract MSGApuestaCraps apostarCraps(MSGApuestaCraps mensaje);

	public abstract MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje);

	public abstract MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje);

	public abstract MSGTiroCraps tirarCraps(MSGTiroCraps unMSG);

}