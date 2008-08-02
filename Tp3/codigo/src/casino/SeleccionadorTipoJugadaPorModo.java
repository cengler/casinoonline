package casino;

import casino.core.TipoJugada;

/**
 * SeleccionadorTipoJugadaPorModo.
 * 
 * @author Grupo2
 *
 */
public class SeleccionadorTipoJugadaPorModo implements ISeleccionadorTipoJugada {

	private static SeleccionadorTipoJugadaPorModo instance;
	private SeleccionadorTipoJugadaPorModo(){}

	/**
	 * Obtiene la unica instancia del SeleccionadorTipoJugadaPorModo.
	 * @return
	 */
	public static SeleccionadorTipoJugadaPorModo getInstance(){
		if(instance == null)
			instance = new SeleccionadorTipoJugadaPorModo();
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public TipoJugada getTipoJugada(IMesa mesa) 
	{
		ICasino c = Casino.getInstance();
		TipoJugada tj = null;
		if(c.isModoNormal())
			tj = SelectorTipoJugadaMN.getInstance().getTipoJugada(mesa);
		else
			tj = SelectorTipoJugadaMD.getInstance().getTipoJugada(mesa);
		return tj;
	}

}