package craps.msg;
import craps.msg.MSGOpcionApuesta;
import java.util.List;
import craps.msg.MSGValorFicha;

public class MSGApostarCraps extends MSGCraps {

	private MSGOpcionApuesta opcionApuesta;
	private List<MSGValorFicha> valorApuesta;
	
	public MSGOpcionApuesta getOpcionApuesta() {
		return opcionApuesta;
	}
	public void setOpcionApuesta(MSGOpcionApuesta opcionApuesta) {
		this.opcionApuesta = opcionApuesta;
	}
	public List<MSGValorFicha> getValorApuesta() {
		return valorApuesta;
	}
	public void setValorApuesta(List<MSGValorFicha> valorApuesta) {
		this.valorApuesta = valorApuesta;
	}
	
	
	
	
}