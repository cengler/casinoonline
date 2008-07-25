package casino.msg;

/**
 * Clase abtracta de modo dirigido.
 * 
 * @author Grupo2
 *
 */
public abstract class MSGModo {

	private boolean aceptado;

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
	
	
}