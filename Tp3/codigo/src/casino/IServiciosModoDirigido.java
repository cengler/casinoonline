package casino;

import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModoDirigido;

/**
 * IServiciosModoDirigido.
 * 
 * @author Grupo2
 *
 */
public interface IServiciosModoDirigido {

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public abstract MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public abstract MSGSetJugada setearJugada(MSGSetJugada mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public abstract MSGSetModoDirigido setModoDirigido(MSGSetModoDirigido mensaje);

}