package casino.msg;

import java.util.List;
public class MSGMesaCraps {

	private int id;
	private List<MSGEstadoJugador> jugadores;
	private MSGProximoTiro proximoTiro;
	private MSGUltimoTiroCraps ultimoTiro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<MSGEstadoJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGEstadoJugador> jugadores) {
		this.jugadores = jugadores;
	}
	public MSGProximoTiro getProximoTiro() {
		return proximoTiro;
	}
	public void setProximoTiro(MSGProximoTiro proximoTiro) {
		this.proximoTiro = proximoTiro;
	}
	public MSGUltimoTiroCraps getUltimoTiro() {
		return ultimoTiro;
	}
	public void setUltimoTiro(MSGUltimoTiroCraps ultimoTiro) {
		this.ultimoTiro = ultimoTiro;
	} 
	
	
}
