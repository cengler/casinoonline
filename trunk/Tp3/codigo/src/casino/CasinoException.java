package casino;

/**
 * CasinoException.
 * 
 * @author Grupo2
 *
 */
@SuppressWarnings("serial")
public class CasinoException extends Exception {

	/**
	 * Constuctor sin parametros.
	 */
	public CasinoException() {}

	/**
	 * Constructor.
	 * 
	 * @param arg0 mensaje de error
	 */
	public CasinoException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor.
	 * 
	 * @param arg0 objeto a enviar en la exception
	 */
	public CasinoException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Constructor.
	 * 
	 * @param arg0 mensaje de error
	 * @param arg1 objeto a enviar en la exception
	 */
	public CasinoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
