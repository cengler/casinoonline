package casino;

/**
 * Interface de Casino.
 * 
 * @author Grupo2
 *
 */
public interface ICasino
{
	/**
	 * Geter del estado del casino que puede ser abierto o cerrado.
	 * 
	 * @return devuelve true si el casino esta abierto.
	 */
	boolean isAbierto() ;

	/**
	 * Geter del modo en que se encuentra el casino. 
	 * El modo puede ser normal o dirigido.
	 * 
	 * @return devuelve true si el modo es normal
	 */
	boolean isModoNormal();

	/**
	 * Geter del monto del pozo feliz.
	 * 
	 * @return el monto del pozo feliz.
	 */
	int getPozoFeliz();
	
	/**
	 * Geter del saldo del casino.
	 * 
	 * @return el saldo del casino.
	 */
	float getSaldo();
	
}


