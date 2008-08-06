package casino;

import org.apache.log4j.Logger;

/**
 * Jugador del casino. Esta clase representa los jugadores 
 * registrados en el casino tanto los logeados como los no logeados.
 *  
 * @author Grupo2
 *
 */
public class Jugador implements IJugador, Comparable<Jugador> {

	private String IdVirt;
	private boolean logeado;
	private boolean vip;
	private boolean modoObservador;
	private String nombre;
	private float saldo;
	private float saldoInicial;
	
	private Logger logger = Logger.getLogger(Jugador.class);

	/**
	 * Constructor.
	 */
	public Jugador(){
		logeado = false;
		IdVirt = "";
	}

	public String getIdVirt() {
		return IdVirt;
	}

	public void setIdVirt(String idVirt) {
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

	public float getSaldo() {
		return saldo;
	}

	/**
	 * Verifica si el jugador no es vip, no se le puede setear saldo negativo.
	 * 
	 * @param saldo saldo a setear al jugador
	 */
	public void setSaldo(float saldo) {
		if(!isVip())
			if(saldo<0)
				logger.error("El saldo de un jugador no VIP no pude ser negativo");
		this.saldo = saldo;
	}
	
	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	/**
	 * El hashCode de jugadores esta dada por el nombre.
	 */
	public int hashCode() {
		return nombre.hashCode();
	}

	/**
	 * La igualdad de jugadores esta dada por el nombre.
	 */
	public boolean equals(Object jug)
	{
		if (jug instanceof Jugador)
            return this.nombre.equals(((Jugador)jug).getNombre());
        else
            return false;
	}

	@Override
	public String toString() {
		return "[J: "+nombre+" saldo: "+saldo+" ]";
	}

	public float getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	/**
	 * Dev 1 -1 o 0.
	 */
	public int compareTo(Jugador jug) {
		
		float gananciaThis = saldo - saldoInicial;
		float gananciaJug = jug.getSaldo() - jug.getSaldoInicial();
		
		return new Float(gananciaThis).compareTo(new Float(gananciaJug));
	}
	
	
}
