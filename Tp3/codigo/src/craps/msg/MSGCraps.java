package craps.msg;

public abstract class MSGCraps {

	public static String SI = "SI";
	public static String NO = "NO";
	
	private String vTerm;
	private String usuario;
	
	/**
	 * cuando mesa = 0 la mesa es nula
	 */
	private int mesa;
	
	/**
	 * este atributo es para comunicarle al solicitante 
	 * si su solicitud se acepto o no.
	 */
	private String aceptado;
	
	/**
	 * es caso de no ser aceptada debe ir 
	 * una descripcion del motivo.
	 */
	private String descripcion;
	
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
	
	public int getMesa() {
		return mesa;
	}
	
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getVTerm() {
		return vTerm;
	}
	
	public void setVTerm(String term) {
		vTerm = term;
	}
	
	public abstract String getName();
	
	
}