package craps;

//import craps.msg.MSGApuestaCraps;
import craps.msg.MSGApostarCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;

public interface IServiciosCraps {

	//MSGApuestaCraps apostarCraps(MSGApuestaCraps mensaje);

	MSGApostarCraps apostarCraps(MSGApostarCraps mensaje);

	MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje);

	MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje);

	MSGTiroCraps tirarCraps(MSGTiroCraps unMSG);
	
	

}