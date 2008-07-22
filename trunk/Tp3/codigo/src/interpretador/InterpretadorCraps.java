package interpretador;

import core.IMessage;
import interpretador.IInterpretadorCasino;

public class InterpretadorCraps implements IInterpretadorCasino {

	private static InterpretadorCraps instance;
	
	private InterpretadorCraps(){}
	
	public IMessage interpretar(IMessage mensaje){
		return null;
	}

	public static InterpretadorCraps getInstance() {
		if(instance == null)
			instance = new InterpretadorCraps();
		return null;
	}

}