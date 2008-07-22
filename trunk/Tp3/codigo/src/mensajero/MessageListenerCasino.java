package mensajero;

import interpretador.InterpretadorCasino;
import core.IMessage;
import core.IMessageListener;

public class MessageListenerCasino implements IMessageListener {

	public MessageListenerCasino(){}

	public IMessage onMessage(IMessage mensaje){
		return InterpretadorCasino.getInstance().interpretar(mensaje);
	}

}