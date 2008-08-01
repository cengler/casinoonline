package craps.msg;


import java.util.List;

import casino.msg.MSGJugador;

public class MSGEstadoCraps extends MSGCraps {

	
	private List<MSGJugador> jugadores;
	private MSGProxTiro proximoTiro;
	private MSGUltimoTiro ultimoTiro;
	private MSGApuestasVigentes apuestasVigentes;
	
	
	public MSGApuestasVigentes getApuestasVigentes() {
		return apuestasVigentes;
	}
	public void setApuestasVigentes(MSGApuestasVigentes apuestasVigentes) {
		this.apuestasVigentes = apuestasVigentes;
	}
	public List<MSGJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGJugador> jugadores) {
		this.jugadores = jugadores;
	}
	public MSGProxTiro getProximoTiro() {
		return proximoTiro;
	}
	public void setProximoTiro(MSGProxTiro proximoTiro) {
		this.proximoTiro = proximoTiro;
	}
	public MSGUltimoTiro getUltimoTiro() {
		return ultimoTiro;
	}
	public void setUltimoTiro(MSGUltimoTiro ultimoTiro) {
		this.ultimoTiro = ultimoTiro;
	}
	

}