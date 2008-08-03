package mensajero;

import org.apache.log4j.Logger;
import core.IMessage;
import core.IMessageListener;

/**
 * MessageListenerCasino. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class MessageListenerCrapsOut implements IMessageListener {

	private static Logger logger = Logger.getLogger(MessageListenerCrapsOut.class);
	
	/**
	 * Constructor.
	 */
	public MessageListenerCrapsOut(){}
	
	/**
	 * OnMessage, accion a realizar ante el arribo de un mensaje.
	 * 
	 * @param mensaje mensaje que se recibio y debe procesarse.
	 */
	public IMessage onMessage(IMessage mensaje)
	{
		logger.error("Esta mensajero seberia solo enviar respuesas");
		return null; // TODO
	}

}