package craps;

import java.util.Date;

import casino.IJugador;
import craps.msg.TipoApuestaCraps;

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
	private float gananciaBruta;
	private Date fechaCreacion;
	private Date fechaCierre;
	private float montoPremioJugadaFeliz;
	private float montoRetenidoJugadaTodosPonen;
		
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
		gananciaBruta = 0;
		fechaCreacion = new Date(System.currentTimeMillis());
		fechaCierre = null;
		montoPremioJugadaFeliz = 0;
		montoRetenidoJugadaTodosPonen = 0;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa)
	{
		fechaCierre = new Date(System.currentTimeMillis());
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

	public float getGananciaBruta() {
		return gananciaBruta;
	}

	public void setGananciaBruta(float ganancia) {
		this.gananciaBruta = ganancia;
	}

	@Override
	public String toString() {
		return "{ JUG: " + apostador + ", TIPO: " + tipo + ", PUNT: " + puntaje + ", GANBR: " + gananciaBruta + ", ACT: "+ activa+ " }";
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public float getMontoPremioJugadaFeliz() {
		return montoPremioJugadaFeliz;
	}

	public void setMontoPremioJugadaFeliz(float montoPremioJugadaFeliz) {
		this.montoPremioJugadaFeliz = montoPremioJugadaFeliz;
	}

	public float getMontoRetenidoJugadaTodosPonen() {
		return montoRetenidoJugadaTodosPonen;
	}

	public void setMontoRetenidoJugadaTodosPonen(float montoRetenidoJugadaTodosPonen) {
		this.montoRetenidoJugadaTodosPonen = montoRetenidoJugadaTodosPonen;
	}
}