package mensajero;

import parser.IMessage;

public abstract class MensajeroXArchivos extends Mensajero {

	private String dir;
	
	public MensajeroXArchivos(String dir) {
		super();
		this.dir = dir;
	}

	public void closeConnection(){

	}

	public void openConnection(){
		dir.toString();  // TODO
	}

	public IMessage read(){
		return null;
	}

}