package craps.msg;
import java.util.List;

public class MSGUltimoTiro {

	private String tirador;
	private int resultado;
	private List<MSGPremio> premios;
	
	public List<MSGPremio> getPremios() {
		return premios;
	}
	public void setPremios(List<MSGPremio> premios) {
		this.premios = premios;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public String getTirador() {
		return tirador;
	}
	public void setTirador(String tirador) {
		this.tirador = tirador;
	}
	
	
}
