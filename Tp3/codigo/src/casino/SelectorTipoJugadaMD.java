package casino;

public class SelectorTipoJugadaMD implements ISelectorTipoJugada {

	private static SelectorTipoJugadaMD instance;

	private SelectorTipoJugadaMD(){
	}

	public static SelectorTipoJugadaMD getInstance(){
		if(instance != null)
			instance = new SelectorTipoJugadaMD();
		return instance;
	}

	public TipoJugada getTipoJugada() {
		return null;
	}

}