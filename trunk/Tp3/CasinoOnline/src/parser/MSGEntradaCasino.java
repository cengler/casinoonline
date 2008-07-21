package parser;

public class MSGEntradaCasino implements IMSG {
	
	private String vTerm;
	
	private String usuario;
	
	private String modoAcceso;
	
	private String aceptado;
	
	private String descripcion;
	
	private int saldo;
	
	public static String MODO_JUGADOR = "modo jugador";
	public static String MODO_OBSERVADOR = "modo observador";
	public static String ACEPTADO_SI = "si";
	public static String ACEPTADO_NO = "no";

	/**
	 * @return the modoAcceso
	 */
	public String getModoAcceso() {
		return modoAcceso;
	}

	/**
	 * @param modoAcceso the modoAcceso to set
	 */
	public void setModoAcceso(String modoAcceso) {
		this.modoAcceso = modoAcceso;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the vTerm
	 */
	public String getVTerm() {
		return vTerm;
	}

	/**
	 * @param term the vTerm to set
	 */
	public void setVTerm(String term) {
		vTerm = term;
	}

	public String getAceptado() {
		return aceptado;
	}

	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	
	
	
}
