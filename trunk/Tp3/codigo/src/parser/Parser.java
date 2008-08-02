package parser;

import org.apache.log4j.Logger;
import com.thoughtworks.xstream.XStream;
import core.IMessage;

public abstract class Parser {

	private static Logger logger = Logger.getLogger(Parser.class);
	protected static XStream xstream;
	
	public Object parse(IMessage is) throws ParserException
	{	
		try
		{
			logger.debug("parseando... " + is.getName() + "\n ------------------- \n" + 
					is.getData() + " ------------------- ");
			Object message; 
			String s = is.getData();
			message = xstream.fromXML(s.trim());
			logger.debug("parseando: " + message + "\n P>------------------ \n" + 
					is.getData() + " P>------------------ ");
			return message;
		}catch(RuntimeException re)
		{
			logger.error("SE RE COLGO! " + re.getMessage() + " "+ re.getCause(), re);
			throw new ParserException(re) ;
		}
	}
	
	/**
	 * Senderiza dentro del IMensaje al mensaje recibido como primer parametro.
	 * 
	 * @param msg mensaje a renderizar
	 * @param imsg IMensaje a llenar con la informacion 
	 * @throws ParserException en caso de un error en el parser
	 */
	public void renderizar(Object msg, IMessage imsg) throws ParserException
	{
		imsg.setData(xstream.toXML(msg));
	}
}