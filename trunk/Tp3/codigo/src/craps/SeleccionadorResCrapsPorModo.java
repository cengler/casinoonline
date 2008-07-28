package craps;

import casino.SeleccionadorTipoJugadaPorModo;

public class SeleccionadorResCrapsPorModo implements ISeleccionadorResCraps {

	private static SeleccionadorResCrapsPorModo instance;
	public ResultadoCraps getResult(){}
	public SeleccionadorResCrapsPorModo(){

	}
	
	public static SeleccionadorResCrapsPorModo getInstance(){
		if(instance == null)
			instance = new SeleccionadorResCrapsPorModo();
		return instance;
	}
	
	public void finalize() throws Throwable {

	}

	/*public <val, val> getResult(){
		return null;
	}*/


		
	}

