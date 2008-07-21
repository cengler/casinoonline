package casino;

public class SelectorTipoJugadaMN implements ISelectorTipoJugada {

	private static SelectorTipoJugadaMN instance;

	public SelectorTipoJugadaMN(){

	}

	public static SelectorTipoJugadaMN getInstance()
	{
		if(instance != null)
			return instance;
		return new SelectorTipoJugadaMN();
	}

	public TipoJugada getTipoJugada() {
		// TODO Auto-generated method stub
		return null;
	}

}