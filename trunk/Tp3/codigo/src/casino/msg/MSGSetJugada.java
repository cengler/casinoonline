package casino.msg;

import casino.TipoJugada;

public class MSGSetJugada extends MSGModo {

	private TipoJugada tipo;
	private String juego;
	private int mesa;
	
	public TipoJugada getTipo() {
		return tipo;
	}
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