package casino;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.estadoCasino.MSGEstadoCasino;

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
	public abstract MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public abstract MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	public abstract MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje);
}