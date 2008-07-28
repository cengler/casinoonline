package craps;

import casino.Casino;

public class SeleccionadorResCrapsPorModo implements ISeleccionadorResCraps {

	private static SeleccionadorResCrapsPorModo instance;
	
	public SeleccionadorResCrapsPorModo(){

	}
	
	public static SeleccionadorResCrapsPorModo getInstance(){
		if(instance == null)
			instance = new SeleccionadorResCrapsPorModo();
		return instance;
	}

	public ResultadoCraps getResult()
	{
		ISelectorResCraps selector = null; 
		if(Casino.getInstance().isModoNormal())
			selector = SelectorResCrapsModoNormal.getInstance();
		else
			selector = SelectorResCrapsModoDirigido.getInstance();
		return selector.getResult();
	}
	/*public <val, val> getResult(){
		return null;
	}*/


		
	}

