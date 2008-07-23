package craps.msg;
import craps.msg.MSGResultadoCraps;

public class MSGTiroCraps extends MSGCraps {

	private String tipoJugada;
	private MSGResultadoCraps  resultado;
	
	public MSGResultadoCraps getResultado() {
		return resultado;
	}
	public void setResultado(MSGResultadoCraps resultado) {
		this.resultado = resultado;
	}
	public String getTipoJugada() {
		return tipoJugada;
	}
	public void setTipoJugada(String tipoJugada) {
		this.tipoJugada = tipoJugada;
	}
}	