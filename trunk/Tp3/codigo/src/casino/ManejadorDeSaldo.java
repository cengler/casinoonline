package casino;

/**
 * Manejador de saldo. Esta es la unica clase que deberia 
 * modificar el saldo de los jugadores y el casino.
 * 
 * @author Grupo2
 *
 */
public class ManejadorDeSaldo {

	private int montoFeliz;
	
	private static ManejadorDeSaldo instance;

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

	public int getMontoFeliz() {
		return montoFeliz;
	}

	//TODO ver si esta bien tener el set
	public void setMontoFeliz(int montoFeliz) {
		this.montoFeliz = montoFeliz;
	}

	public void pagarJugada(TipoJugada tipoJugada, int monto, IJugador jugador){

	}

	public void pagoDeApuesta(int monto, IJugador jugador){

	}

}
