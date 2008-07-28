package casino;

/**
 * Casino. Singleton que representa a las propiedades 
 * basicas del casino online
 * 
 * @author Grupo2
 *
 */
public class Casino implements ICasino {

	private boolean abierto;
	private static Casino instance;
	private boolean modoNormal;
	private int pozoFeliz;
	private long saldo;

	/**
	 * Constructor.
	 */
	private Casino(){
		abierto = false;
		modoNormal = true;
	}

	/**
	 * Obtiene la unica instancia de casino.
	 * 
	 * @return la unica instancia de casino.
	 */
	public static Casino getInstance(){
		if(instance == null)
			instance = new Casino();
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isModoNormal() {
		return modoNormal;
	}

	public void setModoNormal(boolean modoNormal) {
		this.modoNormal = modoNormal;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPozoFeliz() {
		return pozoFeliz;
	}

	public void setPozoFeliz(int pozoFeliz) {
		this.pozoFeliz = pozoFeliz;
	}

	/**
	 * {@inheritDoc}
	 */
	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}
}