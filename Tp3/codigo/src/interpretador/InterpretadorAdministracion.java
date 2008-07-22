package interpretador;

import core.IMessage;

public class InterpretadorAdministracion implements IInterpretadorCasino {

	private static InterpretadorAdministracion instance; 
	
	private InterpretadorAdministracion(){

	}

	public IMessage interpretar(IMessage mensaje){
		return null;
	}

	public InterpretadorAdministracion getInstance() {
		if(instance == null)
			instance = new InterpretadorAdministracion();
		return instance;
	}

}