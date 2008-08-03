package casino.msg;

import java.util.List;


public class MSGEstadoCasino extends MSGCasino {

	private List<MSGEstadoJugador> jugadores;
	private List<MSGObservador> observadores;
	private List<IMSGJuego> juegos;
	private MSGPozo pozosCasino;

	public List<MSGEstadoJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGEstadoJugador> jugadores) {
		this.jugadores = jugadores;
	}
	public List<IMSGJuego> getJuegos() {
		return juegos;
	}
	public void setJuegos(List<IMSGJuego> juegos) {
		this.juegos = juegos;
	}
	public List<MSGObservador> getObservadores() {
		return observadores;
	}
	public void setObservadores(List<MSGObservador> observadores) {
		this.observadores = observadores;
	}
	public MSGPozo getPozosCasino() {
		return pozosCasino;
	}
	public void setPozosCasino(MSGPozo pozosCasino) {
		this.pozosCasino = pozosCasino;
	}
	
	

	
}