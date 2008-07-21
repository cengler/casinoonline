package traga;

public class SeleccionadorResTragaPorModo implements ISeleccionadorResTraga {

	private static SeleccionadorResTragaPorModo instance;

	public SeleccionadorResTragaPorModo(){

	}

	public void finalize() throws Throwable {

	}

	public static SeleccionadorResTragaPorModo getInstance(){
		if(instance == null)
			instance = new SeleccionadorResTragaPorModo();
		return instance;
	}

	public ResultTraga getResult(){
		return null;
	}

}