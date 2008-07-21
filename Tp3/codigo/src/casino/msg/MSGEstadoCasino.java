package casino.msg;

import java.util.List;

public class MSGEstadoCasino extends MSGCasino {

	private List<MSGJuego> juegos;
	private List<MSGJugador> jugadores;
	private List<MSGObservador> observadores;
	private List<MSGPozo> pozos;
	
	public List<MSGJuego> getJuegos() {
		return juegos;
	}
	public void setJuegos(List<MSGJuego> juegos) {
		this.juegos = juegos;
	}
	public List<MSGJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGJugador> jugadores) {
		this.jugadores = jugadores;
	}
	public List<MSGObservador> getObservadores() {
		return observadores;
	}
	public void setObservadores(List<MSGObservador> observadores) {
		this.observadores = observadores;
	}
	public List<MSGPozo> getPozos() {
		return pozos;
	}
	public void setPozos(List<MSGPozo> pozos) {
		this.pozos = pozos;
	}

	
}