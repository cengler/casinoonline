package craps.msg;

public class MSGPremio {

	private String apostador;
	private int montoPremioJugada;
	private int montoPremioJugadaFeliz;
	private int montoRetenidoJugadaTodosPonen;
	
	public String getApostador() {
		return apostador;
	}
	public void setApostador(String apostador) {
		this.apostador = apostador;
	}
	public int getMontoPremioJugada() {
		return montoPremioJugada;
	}
	public void setMontoPremioJugada(int montoPremioJugada) {
		this.montoPremioJugada = montoPremioJugada;
	}
	public int getMontoPremioJugadaFeliz() {
		return montoPremioJugadaFeliz;
	}
	public void setMontoPremioJugadaFeliz(int montoPremioJugadaFeliz) {
		this.montoPremioJugadaFeliz = montoPremioJugadaFeliz;
	}
	public int getMontoRetenidoJugadaTodosPonen() {
		return montoRetenidoJugadaTodosPonen;
	}
	public void setMontoRetenidoJugadaTodosPonen(int montoRetenidoJugadaTodosPonen) {
		this.montoRetenidoJugadaTodosPonen = montoRetenidoJugadaTodosPonen;
	}
	
	
}
