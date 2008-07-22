package interpretador;

import core.IMessage;

public class InterpretadorTraga implements IInterpretadorCasino {

	private static InterpretadorTraga instance; 
	
	private InterpretadorTraga(){

	}

	public IMessage interpretar(IMessage mensaje){
		return null;
	}

	public InterpretadorTraga getInstance() {
		if(instance == null)
			instance = new InterpretadorTraga();
		return instance;
	}

}