package interpretador;

import core.IMessage;

public class InterpretadorCasino implements IInterpretadorCasino {

	private static InterpretadorCasino instance; 
	
	private InterpretadorCasino(){}

	public IMessage interpretar(IMessage mensaje) {
		// TODO Auto-generated method stub
		return null;
	}

	public static InterpretadorCasino getInstance() {
		if(instance == null)
			instance = new InterpretadorCasino();
		return instance;
	}

}