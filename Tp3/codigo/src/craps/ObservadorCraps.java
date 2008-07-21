package craps;

import java.util.Observable;
import java.util.Observer;

import casino.IMesa;

public class ObservadorCraps implements Observer {

	public ObservadorCraps(){

	}

	public void finalize() throws Throwable {

	}

	public IMesa getMesa(){
		return null;
	}

	public void notificar(){

	}

	/**
	 * 
	 * @param mesa
	 */
	public void setMesa(IMesa mesa){
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}