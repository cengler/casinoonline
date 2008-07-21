package casino.msg.estadoCasino;

import java.util.List;

import casino.msg.MSGCasino;

public class MSGEstadoCasino extends MSGCasino {

	private int vTerm;
	private String usuario;
	private List<MSGJugador> jugadores;
	private List<MSGObservador> observadores;
	private List<IMSGJuego> juegos;
	private MSGPozo pozosCasino;
	
	public List<MSGJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGJugador> jugadores) {
		this.jugadores = jugadores;
	}
	public List<IMSGJuego> getJuegos() {
		return juegos;
	}
	public void setJuegos(List<IMSGJuego> juegos) {
		this.juegos = juegos;
	}
	public int getVTerm() {
		return vTerm;
	}
	public void setVTerm(int term) {
		vTerm = term;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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