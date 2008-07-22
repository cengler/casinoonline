package mensajero;

import interpretador.InterpretadorAdministracion;
import core.IMessage;
import core.IMessageListener;

/**
 * MessageListenerAdministracion. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class MessageListenerAdministracion implements IMessageListener {

	/**
	 * Constructor.
	 */
	public MessageListenerAdministracion(){}

	/**
	 * OnMessage, accion a realizar ante el arribo de un mensaje.
	 * 
	 * @param mensaje mensaje que se recibio y debe procesarse.
	 */
	public IMessage onMessage(IMessage mensaje){
		return InterpretadorAdministracion.getInstance().interpretar(mensaje);
	}

}