package mensajero;

import parser.IMessage;

public interface MessageListener {

	/**
	 * 
	 * @param mensaje
	 */
	public IMessage onMessage(IMessage mensaje);

}