package casino;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGEstadoCasino;

/**
 * IServiciosCasino.
 * 
 * @author Grupo2
 *
 */
public interface IServiciosCasino {

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje);
}