package casino;

public class Jugador implements IJugador {

	private int IdVirt;
	private boolean logeado;
	private boolean modoObservador;
	private String nombre;
	private long saldo;

	public Jugador(){

	}

	public int getIdVirt() {
		return IdVirt;
	}

	public void setIdVirt(int idVirt) {
		IdVirt = idVirt;
	}

	public boolean isLogeado() {
		return logeado;
	}

	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}

	public boolean isModoObservador() {
		return modoObservador;
	}

	public void setModoObservador(boolean modoObservador) {
		this.modoObservador = modoObservador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}
	
	public boolean equals(Object jug)
	{
		if (jug instanceof Jugador)
            return this.nombre.equals(((Jugador)jug).getNombre());
        else
            return false;
	}

	


}