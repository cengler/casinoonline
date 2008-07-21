package mensajero;

import parser.IMessage;

public abstract class Mensajero {

	private boolean con;
	private MessageListener listener;

	public Mensajero(){

	}

	public void finalize() throws Throwable {

	}

	public void closeConnection(){
		con = false;
	}

	/**
	 * 
	 * @param mensaje
	 */
	public void onMessage(IMessage mensaje){

	}

	public void openConnection(){
		con = true;
	}

	public abstract IMessage read();

	public void recive(){

	}

	public void send(IMessage mensaje, Number id){

	}

	public void setListener(MessageListener listener){
		this.listener = listener;
	}

}