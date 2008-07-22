package mensajero;

import interpretador.InterpretadorCasino;
import interpretador.InterpretadorCraps;
import core.IMessage;
import core.IMessageListener;

public class MessageListenerCraps implements IMessageListener {

	public MessageListenerCraps(){}


	public IMessage onMessage(IMessage mensaje){
		return InterpretadorCraps.getInstance().interpretar(mensaje);
	}

}