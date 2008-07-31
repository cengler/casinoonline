package craps.msg;

import casino.TipoJugada;
import craps.msg.MSGResultadoCraps;


public class MSGTiroCraps extends MSGCraps {

	private TipoJugada tipoJugada;
	private MSGResultadoCraps  resultado;
	
	public MSGResultadoCraps getResultado() {
		return resultado;
	}
	public void setResultado(MSGResultadoCraps resultado) {
		this.resultado = resultado;
	}
	public TipoJugada getTipoJugada() {
		return tipoJugada;
	}
	public void setTipoJugada(TipoJugada tipoJugada) {
		this.tipoJugada = tipoJugada;
	}

}	