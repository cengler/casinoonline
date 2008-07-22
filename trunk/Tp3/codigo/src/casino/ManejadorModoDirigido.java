package casino;

import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGsetModoDirigido;


public class ManejadorModoDirigido implements IServiciosModoDirigido {

	private static IServiciosModoDirigido instance;
	
	private ManejadorModoDirigido(){}

	public static IServiciosModoDirigido getInstance()
	{
		if(instance == null)
			instance = new ManejadorModoDirigido();
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see casino.IServiciosModoDirigido#resetModoDirigido(casino.msg.MSGResetModoDirigido)
	 */
	public MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje){
		return null;
	}

	/* (non-Javadoc)
	 * @see casino.IServiciosModoDirigido#setearJugada(casino.msg.MSGSetJugada)
	 */
	public MSGSetJugada setearJugada(MSGSetJugada mensaje){
		return null;
	}

	/* (non-Javadoc)
	 * @see casino.IServiciosModoDirigido#setModoDirigido(casino.msg.MSGsetModoDirigido)
	 */
	public MSGsetModoDirigido setModoDirigido(MSGsetModoDirigido mensaje){
		return null;
	}

}