package casino;

/**
 * ISelectorTipoJugada.
 * 
 * @author Grupo2
 *
 */
public interface ISelectorTipoJugada {

	/**
	 * Obtiene el tipo de jugada para la proxima jugada.
	 */
	public TipoJugada getTipoJugada(IMesa mesa);

}
