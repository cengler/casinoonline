package casino.msg.estadoCasino;

public class MSGProximoTiro {

	public static String SI = "Si";
	public static String NO = "No";
	
	
	private String tirador;
	private String tiroSalida;
	private int punto;
	
	public String getTirador() {
		return tirador;
	}
	public void setTirador(String tirador) {
		this.tirador = tirador;
	}
	public String getTiroSalida() {
		return tiroSalida;
	}
	public void setTiroSalida(String tiroSalida) {
		this.tiroSalida = tiroSalida;
	}
	public int getPunto() {
		return punto;
	}
	public void setPunto(int punto) {
		this.punto = punto;
	}
	
	
}
