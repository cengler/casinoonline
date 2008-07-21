package casino;

public class Casino implements ICasino {

	private boolean abierto;
	private static Casino instance;
	private boolean modoNormal;
	private int pozoFeliz;
	private long saldo;

	public Casino(){

	}

	public static Casino getInstance(){
		if(instance != null)
			return instance;
		else
			instance = new Casino();
		return instance;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	public boolean isModoNormal() {
		return modoNormal;
	}

	public void setModoNormal(boolean modoNormal) {
		this.modoNormal = modoNormal;
	}

	public int getPozoFeliz() {
		return pozoFeliz;
	}

	public void setPozoFeliz(int pozoFeliz) {
		this.pozoFeliz = pozoFeliz;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	

}