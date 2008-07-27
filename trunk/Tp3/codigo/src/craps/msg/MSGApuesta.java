package craps.msg;

import java.util.List;

public class MSGApuesta {

	private String apostador; 
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
	public String getApostador() {
		return apostador;
	}
	public void setApostador(String apostador) {
		this.apostador = apostador;
	}
	
	
}
