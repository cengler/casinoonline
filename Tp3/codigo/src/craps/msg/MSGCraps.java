package craps.msg;

public class MSGCraps {

	public static String SI = "SI";
	public static String NO = "NO";
	
	private int vTerm;
	private String usuario;
	private int mesa; //cuando mesa = 0 la mesa es nula
	private String aceptado; //este atributo es para comunicarle al solicitante 
	//si su solicitud se acepto  o no
	private String descripcion; //es caso de no ser aceptada debe ir una descripcion
	//del motivo
	
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
	public int getVTerm() {
		return vTerm;
	}
	public void setVTerm(int term) {
		vTerm = term;
	}
	
	
}