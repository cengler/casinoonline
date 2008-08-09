package casino.msg;

import java.util.List;


public class MSGEntradaCasino extends MSGCasino {

	public static String MODO_JUGADOR = "jugador";
	public static String MODO_OBSERVADOR = "observador";
	private String modoAcceso;
	private float saldo;
	private static String NAME = "EntradaCasino";
	private List<MSGValorFichaCasino> fichasHabilitadas;
	public String getName() {
		return NAME;
	}

	public float getSaldo()
	{
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String getModoAcceso() {
		return modoAcceso;
	}
	public void setModoAcceso(String modoAcceso) {
		this.modoAcceso = modoAcceso;
	}

	public List<MSGValorFichaCasino> getFichasHabilitadas() {
		return fichasHabilitadas;
	}

	public void setFichasHabilitadas(List<MSGValorFichaCasino> fichasHabilitadas) {
		this.fichasHabilitadas = fichasHabilitadas;
	}
	
	
}