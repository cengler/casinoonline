package casino;

public class SeleccionadorTipoJugadaPorModo implements ISeleccionadorTipoJugada {

	private static SeleccionadorTipoJugadaPorModo instance;

	private SeleccionadorTipoJugadaPorModo(){}

	public static SeleccionadorTipoJugadaPorModo getInstance(){
		if(instance == null)
			instance = new SeleccionadorTipoJugadaPorModo();
		return instance;
	}
	
	public TipoJugada getTipoJugada(IMesa mesa) 
	{
		// TODO VER SI CAMBIAR DISEÑO
		ICasino c = Casino.getInstance();
		TipoJugada tj = null;
		if(c.isModoNormal())
			tj = SelectorTipoJugadaMN.getInstance().getTipoJugada(mesa);
		else
			tj = SelectorTipoJugadaMD.getInstance().getTipoJugada(mesa);
		return tj;
	}

}