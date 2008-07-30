package casino.msg;
import casino.TipoJugada;

/**
 * MSGSetJugada.
 * 
 * @author Grupo2
 *
 */
public class MSGSetJugada extends MSGModo {

	private TipoJugada tipo;
	private String juego;
	private int mesa;
	
	/**
	 * Geter del tipo de jugada a setear.
	 * @return
	 */
	public TipoJugada getTipo() {
		return tipo;
	}
	
	/**
	 * Seter del tipo de jugada a setear.
	 * 
	 * @param tipo el tipo de jugada a setear.
	 */
	public void setTipo(TipoJugada tipo) {
		this.tipo = tipo;
	}
	
	public String getJuego() {
		return juego;
	}
	
	public void setJuego(String juego) {
		this.juego = juego;
	}

	public int getMesa() {
		return mesa;
	}
	
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
	
}