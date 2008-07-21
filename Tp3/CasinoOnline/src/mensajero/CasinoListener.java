package mensajero;

import interpreter.Interpreter;

import org.apache.log4j.Logger;

public class CasinoListener implements IMessageListener {

	private Logger logger = Logger.getLogger(CasinoListener.class);
	
	public void onMessage(IMessage msg) 
	{
		logger.debug("On Message: " + msg.getName());
		
		Interpreter.getInstance().interpreta(msg);
		
		
	}

}
