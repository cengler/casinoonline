package casino.msg.estadoCasino;

public class MSGMesaTragamonedas {

	private int id;
	private MSGJugador jugador;
	private MSGUltimoTiroTraga ultimoTiroTraga;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MSGJugador getJugador() {
		return jugador;
	}
	public void setJugador(MSGJugador jugador) {
		this.jugador = jugador;
	}
	public MSGUltimoTiroTraga getUltimoTiroTraga() {
		return ultimoTiroTraga;
	}
	public void setUltimoTiroTraga(MSGUltimoTiroTraga ultimoTiroTraga) {
		this.ultimoTiroTraga = ultimoTiroTraga;
	}
	
	
}
