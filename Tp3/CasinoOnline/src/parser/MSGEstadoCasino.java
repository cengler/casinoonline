package parser;

import java.util.List;



public class MSGEstadoCasino implements IMSG {

	private List<MSGJugador> jugadores;
	
	private List<MSGObservador> observadores;
	
	private List<IMSGJuego> juegos;
	
	private MSGPozosCasino pozosCasino;
	
	private String vTerm;
	
	private String usuario;

	public List<IMSGJuego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<IMSGJuego> juegos) {
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

	public MSGPozosCasino getPozosCasino() {
		return pozosCasino;
	}

	public void setPozosCasino(MSGPozosCasino pozosCasino) {
		this.pozosCasino = pozosCasino;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getVTerm() {
		return vTerm;
	}

	public void setVTerm(String term) {
		vTerm = term;
	}

}
