package interpretador;

import core.IMessage;

public class InterpretadorSalidaCraps {

	private static InterpretadorSalidaCraps instance; 
	
	private InterpretadorSalidaCraps(){

	}

	public void interpreta(IMessage mensaje){

	}
	
	public static InterpretadorSalidaCraps getInstance()
	{
		if(instance == null)
			instance = new InterpretadorSalidaCraps();
		return instance;
	}

}