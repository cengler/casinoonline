package casino.msg;

public abstract class MSGCasino {

	private int vTerm;
	private String usuario;
	private String descripcion;
	private String aceptado;
	
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