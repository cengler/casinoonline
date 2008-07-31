package parser;

import org.apache.log4j.Logger;
import com.thoughtworks.xstream.XStream;
import core.IMessage;

public abstract class Parser {

	private static Logger logger = Logger.getLogger(Parser.class);
	protected static XStream xstream;
	
	public Object parse(IMessage is) throws ParserException
	{	
		logger.debug("parseando..." + is.getName() );
		Object message;
		message = xstream.fromXML(is.getData());
		
		return message;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void renderizar(Object msg, IMessage imsg) throws ParserException
	{
		imsg.setData(xstream.toXML(msg));
	}
}