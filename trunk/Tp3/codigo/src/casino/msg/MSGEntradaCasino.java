package casino.msg;

public class MSGEntradaCasino extends MSGCasino {

	private String descripcion;
	private String modoAcceso;
	private int saldo;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModoAcceso() {
		return modoAcceso;
	}
	public void setModoAcceso(String modoAcceso) {
		this.modoAcceso = modoAcceso;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	

}