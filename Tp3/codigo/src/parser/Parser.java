package parser;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;

import core.IMessage;
import core.NoDataException;

public abstract class Parser {

	private static Logger logger = Logger.getLogger(Parser.class);
	protected static XStream xstream;
	
	public Object parse(IMessage is) throws ParserException
	{	
		//xstream.to.toXML(arg0, arg1)
		/*xstream.toXML(arg0)
		InputStream isi;
		Reader
		isi.
		*/
		
		
		logger.debug("parseando...");
		Object message;
		try {
			message = xstream.fromXML(is.getInputStream());
		} catch (NoDataException e) {
			logger.error("No se pudo obtener la información", e);
			throw new ParserException(e);
		}
		
		try {
			is.getInputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void renderizar(Object msg, IMessage imsg) throws ParserException
	{
		xstream.toXML(msg, imsg.getOutputStream());
		try
		{
			imsg.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}