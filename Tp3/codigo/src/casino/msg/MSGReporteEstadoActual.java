package casino.msg;

import java.util.List;

public class MSGReporteEstadoActual extends MSGReporte{

	private int saldoCasino;
	private List<MSGJugador> jugadores;
	
	public int getSaldoCasino() {
		return saldoCasino;
	}
	public void setSaldoCasino(int saldoCasino) {
		this.saldoCasino = saldoCasino;
	}
	public List<MSGJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGJugador> jugadores) {
		this.jugadores = jugadores;
	}
	

	
}
