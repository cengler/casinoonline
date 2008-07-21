package casino.msg.estadoCasino;

import java.util.List;

public class MSGCraps implements IMSGJuego {

	private List<MSGMesaCraps> mesasCraps;

	public List<MSGMesaCraps> getMesasCraps() {
		return mesasCraps;
	}

	public void setMesasCraps(List<MSGMesaCraps> mesasCraps) {
		this.mesasCraps = mesasCraps;
	}
	
	
}
