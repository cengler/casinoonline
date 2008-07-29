package craps;

import casino.IJugador;

/**
 * ISeleccionadorDeTirador.
 * 
 * @author Grupo2
 *
 */
public interface ISeleccionadorDeTirador {

	/**
	 * Obtiene el proximo tiardor a setear en la mesa.
	 * Notese: no actualiza el tirador, solo obtiene al asignado.
	 * 
	 * @param mesa mesa que quiere actualizar el tirador
	 * @return el proximo tiardor a setear en la mesa.
	 */
	IJugador getProxTirador(MesaCraps mesa);

}