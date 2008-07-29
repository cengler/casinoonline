package craps;

import org.apache.log4j.Logger;

import casino.Casino;

public class SeleccionadorResCrapsPorModo implements ISeleccionadorResCraps {

	private static Logger logger = Logger.getLogger(SeleccionadorResCrapsPorModo.class);
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
		
		ResultadoCraps res = selector.getResult();
		logger.debug(res);
		
		return res;
	}
	/*public <val, val> getResult(){
		return null;
	}*/


		
	}

