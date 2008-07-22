package mensajero;

import interpretador.InterpretadorCasino;
import core.IMessage;
import core.IMessageListener;

/**
 * MessageListenerCasino. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class MessageListenerCasino implements IMessageListener {

	/**
	 * Constructor.
	 */
	public MessageListenerCasino(){}
	
	/**
	 * OnMessage, accion a realizar ante el arribo de un mensaje.
	 * 
	 * @param mensaje mensaje que se recibio y debe procesarse.
	 */
	public IMessage onMessage(IMessage mensaje){
		return InterpretadorCasino.getInstance().interpretar(mensaje);
	}

}