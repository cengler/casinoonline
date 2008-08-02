package casino.msg;


public class MSGEntradaCasino extends MSGCasino {

	private String modoAcceso;
	private int saldo;

	public int getSaldo() {
		return saldo;	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public String getModoAcceso() {
		return modoAcceso;
	}
	public void setModoAcceso(String modoAcceso) {
		this.modoAcceso = modoAcceso;
	}
}