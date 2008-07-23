package casino.msg;

/**
 * @version 1.0
 * @created 18-Jul-2008 19:48:49
 */
public abstract class MSGAdministracion {

	private boolean aceptado;
	private String descripcion;

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}