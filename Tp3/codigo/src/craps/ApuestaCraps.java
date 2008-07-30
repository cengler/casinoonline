package craps;

import casino.IJugador;

/**
 * Clase ApuestaCraps.
 * 
 * @author Grupo2
 *
 */
public class ApuestaCraps {

	private IJugador apostador;
	private int puntaje;
	private TipoApuestaCraps tipo;
	private int valor;
	private boolean activa;
	private int ganancia;
		
	/**
	 * Constructor sin parametros.
	 *
	 */
	public ApuestaCraps(){}

	/**
	 * Constructor.
	 * 
	 * @param apostador jugador que realiza la apuesta
	 * @param puntaje puntaje al que apuesta
	 * @param tipo tipo de apuesta
	 * @param valor monto a apostar
	 */
	public ApuestaCraps(IJugador apostador, int puntaje, TipoApuestaCraps tipo, int valor) {
		super();
		this.apostador = apostador;
		this.puntaje = puntaje;
		this.tipo = tipo;
		this.valor = valor;
		this.activa = true;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public IJugador getApostador() {
		return apostador;
	}

	public void setApostador(IJugador apostador) {
		this.apostador = apostador;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public TipoApuestaCraps getTipo() {
		return tipo;
	}

	public void setTipo(TipoApuestaCraps tipo) {
		this.tipo = tipo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getGanancia() {
		return ganancia;
	}

	public void setGanancia(int ganancia) {
		this.ganancia = ganancia;
	}

	public boolean terminaApuesta(ResultadoCraps resultado) {
		// TODO Auto-generated method stub
		return false;
	}

	public int obtenerGanancia(ResultadoCraps resultado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "{ JUG: " + apostador + ", TIPO: " + tipo + ", PUNT: " + puntaje + ", GAN: " + ganancia + ", ACT: "+ activa+ " }";
	}
	

}