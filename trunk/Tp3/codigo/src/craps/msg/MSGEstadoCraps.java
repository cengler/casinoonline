package craps.msg;


import java.util.List;

import craps.msg.MSGJugadorCraps;

public class MSGEstadoCraps extends MSGCraps
{
	private List<MSGJugadorCraps> jugadores;
	private MSGProxTiro proximoTiro;
	private MSGUltimoTiro ultimoTiro;
	private MSGApuestasVigentes apuestasVigentes;
	private static String NAME = "EstadoCraps";

	public String getName() {
		return NAME;
	}
	
	
	public MSGApuestasVigentes getApuestasVigentes() {
		return apuestasVigentes;
	}
	public void setApuestasVigentes(MSGApuestasVigentes apuestasVigentes) {
		this.apuestasVigentes = apuestasVigentes;
	}
	public List<MSGJugadorCraps> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<MSGJugadorCraps> jugadores) {
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