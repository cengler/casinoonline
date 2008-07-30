package casino;

import java.util.Map;
import java.util.HashMap;
/**
 * Casino, Singleton que representa a las propiedades 
 * basicas del casino online.
 * 
 * @author Grupo2
 *
 */
public final class Casino implements ICasino {

	private boolean abierto;
	private static Casino instance;
	private boolean modoNormal;
	private int pozoFeliz;
	private long saldo;
	private Map<Integer, Integer> valores;

	/**
	 * Constructor.
	 */
	private Casino(){              
		abierto = false;
		modoNormal = true;
		valores = new HashMap<Integer,Integer>();
		valores.put(1, 25);
		valores.put(2, 50);
		valores.put(3, 75);
		
	}

	/**
	 * Obtiene las fichas permitidas y sus valores definidos.
	 * 
	 * @return las fichas permitidas y sus valores definidos.
	 */
	
	public Map<Integer, Integer> getValores() {
		return valores;
	}

	
	/**
	 * Setea las fichas permitidas y sus valores definidos.
	 * 
	 * @param valores as fichas permitidas y sus valores definidos a setear
	 */
	
	
	public void setValores(Map<Integer, Integer> valores) {
		this.valores = valores;
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

	/**
	 * Setea si el casino esta abierto.
	 * 
	 * @param abierto true si se quiere abrir el casino
	 */
	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isModoNormal() {
		return modoNormal;
	}

	/**
	 * Setea si el casino esta en modo normal.
	 * 
	 * @param modoNormal true si se quiere pasar al casino a modo normal
	 */
	public void setModoNormal(boolean modoNormal) {
		this.modoNormal = modoNormal;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPozoFeliz() {
		return pozoFeliz;
	}

	/**
	 * Setea el monto del pozo feliz.
	 * 
	 * @param pozoFeliz el monto a setear al pozo feliz
	 */
	public void setPozoFeliz(int pozoFeliz) {
		this.pozoFeliz = pozoFeliz;
	}

	/**
	 * {@inheritDoc}
	 */
	public long getSaldo() {
		return saldo;
	}

	/**
	 * Setea el saldo del casino.
	 * 
	 * @param saldo el saldo a setear al casino
	 */
	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	
	
	/*Error Description Line 
	Parameter valores should be final. 43 
	'valores' hides a field. 43 
	'if' construct must use '{}'s. 53 
	Parameter abierto should be final. 70 
	'abierto' hides a field. 70 
	First sentence should end with a period. 81 
	Parameter modoNormal should be final. 86 
	'modoNormal' hides a field. 86 
	Parameter pozoFeliz should be final. 102 
	'pozoFeliz' hides a field. 102 
	Parameter saldo should be final. 118 
	'saldo' hides a field. 118 */

}
