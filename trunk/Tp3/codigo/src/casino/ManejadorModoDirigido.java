package casino;

import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGsetModoDirigido;


public class ManejadorModoDirigido {

	private static ManejadorModoDirigido instance;
	
	private ManejadorModoDirigido(){}

	public static ManejadorModoDirigido getInstance()
	{
		if(instance == null)
			instance = new ManejadorModoDirigido();
		return instance;
	}
	
	public MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje){
		return null;
	}

	/**
	 * 
	 * @param mensaje
	 */
	public MSGSetJugada setearJugada(MSGSetJugada mensaje){
		return null;
	}

	/**
	 * 
	 * @param mensaje
	 */
	public MSGsetModoDirigido setModoDirigido(MSGsetModoDirigido mensaje){
		return null;
	}

}