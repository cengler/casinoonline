package casino;

import casino.msg.TipoJugada;

/**
 *  ISeleccionadorTipoJugada especifica la manera de seleccionar el tipo de jugada.
 *  Contiene el algoritmo de seleccion entre selectores de tipo de jugada
 * 
 * @author Grupo2
 *
 */
public interface ISeleccionadorTipoJugada {

	/**
	 * Obtiene el tipo de jugada para la mesa en particular.
	 * IMPORTANTE: una vez obtenido el tipo de jugada no se deberia consultar de nuevo, 
	 * pues ya no seria el tipo de jugada para esta juada, sino para la siguiente.
	 * 
	 * @param mesa mesa de la cual estoy obteniendo el tipo de jugada.
	 * @return el tipo de jugada para la siguiente jugada de la mesa
	 */
	TipoJugada getTipoJugada(IMesa mesa);

}
