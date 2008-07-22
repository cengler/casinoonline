package mensajero;

import interpretador.InterpretadorCraps;
import core.IMessage;
import core.IMessageListener;

/**
 * MessageListenerCraps. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class MessageListenerCraps implements IMessageListener {
	
	/**
	 * Constructor.
	 */
	public MessageListenerCraps(){}
	
	/**
	 * OnMessage, accion a realizar ante el arribo de un mensaje.
	 * 
	 * @param mensaje mensaje que se recibio y debe procesarse.
	 */
	public IMessage onMessage(IMessage mensaje){
		return InterpretadorCraps.getInstance().interpretar(mensaje);
	}

}