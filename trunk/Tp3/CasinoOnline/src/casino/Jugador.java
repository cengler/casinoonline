package casino;

public class Jugador extends Cliente implements IJugador{

	private int saldo;
	private boolean vip;
	private boolean logeado;

	public Jugador() {
		super();
		saldo = 0;
		vip = false;
		logeado = false;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public boolean isLogeado() {
		return logeado;
	}

	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " Saldo: " + saldo + " vip: " + vip + " logeado: " + logeado; 
	}

	
	
	
	
}
