package casino;

/**
 * IJugador. Interface para el uso del jugador 
 * del casino desde otros parquetes que no sean casino.
 * 
 * @author Grupo2
 *
 */
public interface IJugador extends ICliente{

	/**
	 * {@inheritDoc}
	 */
	int getIdVirt();

	/**
	 * Informa si el jugador esta logeado en el casino.
	 * 
	 * @return true si el jugador esta logeado en el casino.
	 */
	boolean isLogeado();
	
	/**
	 * Informa si el jugador es un jugador VIP del casino.
	 * 
	 * @return si el jugador es un jugador VIP del casino.
	 */
	boolean isVip();

	/**
	 * Informa si el jugador esta logeado de modo observador.
	 * 
	 * @return
	 */
	boolean isModoObservador();
	// TODO VER SI AL OBTENER JUGADOR LOGEADO 
	// VERIFICAMOS QUE NO ESTE DE MODO OBSERVADOR
	
	/**
	 * {@inheritDoc}
	 */
	String getNombre();

	/**
	 * Obtiene el saldo del jugador.
	 * 
	 * @return el saldo del jugador
	 */
	int getSaldo();

}
