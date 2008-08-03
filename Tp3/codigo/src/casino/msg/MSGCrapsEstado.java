package casino.msg;

import java.util.List;

public class MSGCrapsEstado implements IMSGJuego {

	private List<MSGMesaCraps> mesasCraps;

	public List<MSGMesaCraps> getMesasCraps() {
		return mesasCraps;
	}

	public void setMesasCraps(List<MSGMesaCraps> mesasCraps) {
		this.mesasCraps = mesasCraps;
	}
	
	
}
