package casino;

import org.apache.log4j.Logger;


/**
 * Manejador de saldo. Esta es la unica clase que deberia 
 * modificar el saldo de los jugadores y el casino.
 * 
 * @author Grupo2
 *
 */
public class ManejadorDeSaldo {

	private static ManejadorDeSaldo instance;
	private static Logger logger = Logger.getLogger(ManejadorDeSaldo.class);

	/**
	 * Constructor.
	 */
	private ManejadorDeSaldo(){}

	/**
	 * Obtiene la unica instancia del manejador.
	 * 
	 * @return la unica instancia del manejador.
	 */
	public static ManejadorDeSaldo getInstance(){
		if(instance == null)
			instance = new ManejadorDeSaldo();
		return instance;
	}

	public void transferirCasinoAJugador(IJugador jug, float monto)
	{
		logger.info("TRAFERENCIA: casino --> jugador: " + monto);
		Casino casino = Casino.getInstance();
		casino.setSaldo(casino.getSaldo()-monto);
		((Jugador)jug).setSaldo(jug.getSaldo()+monto);
	}
	
	public void transferirPozoFelizAJugador(IJugador jug, float monto)
	{
		logger.info("TRAFERENCIA: pozoFeliz --> jugador: " + monto);
		Casino casino = Casino.getInstance();
		casino.setPozoFeliz(casino.getPozoFeliz()-monto);
		((Jugador)jug).setSaldo(jug.getSaldo()+monto);
	}
	
	public void transferirJugadorAPozoFeliz(IJugador jug, float monto)
	{
		logger.info("TRAFERENCIA: jugador --> pozoFeliz: " + monto);
		Casino casino = Casino.getInstance();
		casino.setPozoFeliz(casino.getPozoFeliz()+monto);
		((Jugador)jug).setSaldo(jug.getSaldo()-monto);
	}
	
	public void transferirJugadorACasino(IJugador jug, float monto)
	{
		logger.info("TRAFERENCIA: jugador --> casino: " + monto);
		Casino casino = Casino.getInstance();
		casino.setSaldo(casino.getSaldo()+monto);
		((Jugador)jug).setSaldo(jug.getSaldo()-monto);
	}
	
	/*public void transferirCasinoAPozoFeliz(float monto)
	{
		Casino casino = Casino.getInstance();
		casino.setPozoFeliz(casino.getPozoFeliz()+monto);
		casino.setSaldo(casino.getSaldo()-monto);
	}*/

}
