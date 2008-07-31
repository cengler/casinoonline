package casino.msg.estadoCasino;

import java.util.List;
public class MSGMesaCraps {

	private int id;
	private List<MSGJugador> jugadores;
	private MSGProximoTiro proximoTiro;
	private MSGUltimoTiroCraps ultimoTiro;
	// TODO VER ^ SI ESTA BIEN ACA SE USABA DE CRAPS MAL
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<MSGJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGJugador> jugadores) {
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
