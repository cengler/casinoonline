package craps;

import casino.IJugador;

public class SeleccionadorDeTiradorEnOrden implements ISeleccionadorDeTirador {

	//private int currentTiradorIndex = 0;
	private static SeleccionadorDeTiradorEnOrden  instance;
	
	public static SeleccionadorDeTiradorEnOrden  getInstance(){
		if(instance == null)
			instance = new SeleccionadorDeTiradorEnOrden ();
		return instance;
	}
	public SeleccionadorDeTiradorEnOrden(){}

	public IJugador getProxTirador(){
		//if(i == )
		return null;
	}

}