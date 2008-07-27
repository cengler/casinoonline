package casino.msg;

/**
 * Clase abtracta de modo dirigido.
 * 
 * @author Grupo2
 *
 */
public abstract class MSGModo {

	public static String DIRIGIDO = "dirigido";
	public static String NORMAL = "normal";
	
	private boolean aceptado;
	private String descripcion;

	/**
	 * isAceptado.
	 * 
	 * @return devuelve true si el mensaje es aceptado
	 */
	public boolean isAceptado() {
		return aceptado;
	}

	/**
	 * setAceptado.
	 * 
	 * @param aceptado bool para indicar si el mensaje es aceptado
	 */
	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	/**
	 * getDescripcion.
	 * 
	 * @return la descripcion de la razon del rechazo o aceptacion del mensaje
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * setDescripcion.
	 * 
	 * @param descripcion la descripcion de la razon del rechazo o aceptacion del mensaje
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}