package casino;

public class ManejadorDeSaldo {

	private static ManejadorDeSaldo instance;

	public ManejadorDeSaldo(){

	}

	public void finalize() throws Throwable {

	}

	public static ManejadorDeSaldo getInstance(){
		if(instance == null)
			instance = new ManejadorDeSaldo();
		return instance;
	}

	public int getMontoFeliz(){
		return 0;
	}

	/**
	 * 
	 * @param tipoJugada
	 * @param monto
	 * @param jugador
	 */
	public void PagarJugada(TipoJugada tipoJugada, int monto, IJugador jugador){

	}

	/**
	 * 
	 * @param monto
	 * @param jugador
	 */
	public void pagoDeApuesta(int monto, IJugador jugador){

	}

}