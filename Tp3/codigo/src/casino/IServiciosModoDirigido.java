package casino;

import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModo;

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
	MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGSetJugada setearJugada(MSGSetJugada mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGSetModo setModoDirigido(MSGSetModo mensaje);

}