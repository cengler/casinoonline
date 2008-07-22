package interpretador;

import core.IMessage;

/**
 * InterpretadorAdministracion.
 * 
 * @author Grupo2
 *
 */
public class InterpretadorAdministracion implements IInterpretadorCasino {

	private static InterpretadorAdministracion instance; 
	
	/**
	 * Constructor.
	 */
	private InterpretadorAdministracion(){

	}

	/**
	 * 
	 * @return
	 */
	public static InterpretadorAdministracion getInstance() {
		if(instance == null)
			instance = new InterpretadorAdministracion();
		return instance;
	}
	
	/**
	 * 
	 */
	public IMessage interpretar(IMessage mensaje){
		return null;
	}



}