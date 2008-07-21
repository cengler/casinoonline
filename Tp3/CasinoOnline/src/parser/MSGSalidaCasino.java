package parser;

public class MSGSalidaCasino implements IMSG {

	private String vTerm;
	
	private String usuario;
	
	private String aceptado;
	
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
	
	
}
