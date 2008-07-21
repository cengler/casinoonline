package parser;

import java.util.List;

public class MSGMesaCraps {

	private String id;
	
	private List<MSGJugador> jugadores;
	
	private String turno;
	
	private MSGUltimoTiroCraps ultimoTiroCraps;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<MSGJugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<MSGJugador> jugadores) {
		this.jugadores = jugadores;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public MSGUltimoTiroCraps getUltimoTiroCraps() {
		return ultimoTiroCraps;
	}

	public void setUltimoTiroCraps(MSGUltimoTiroCraps ultimoTiroCraps) {
		this.ultimoTiroCraps = ultimoTiroCraps;
	}


}
