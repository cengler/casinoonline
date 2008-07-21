package craps;

import casino.ISeleccionadorTipoJugada;
import casino.TipoJugada;

public class SeleccionadorTipoJugadaPorModo implements ISeleccionadorTipoJugada {

	private static SeleccionadorTipoJugadaPorModo instance;

	private SeleccionadorTipoJugadaPorModo(){
	}

	public static SeleccionadorTipoJugadaPorModo getInstance(){
		if(instance != null)
			instance = new SeleccionadorTipoJugadaPorModo();
		return instance;
	}
	
	public TipoJugada getTipoJugada() {
		// TODO Auto-generated method stub
		return null;
	}

}