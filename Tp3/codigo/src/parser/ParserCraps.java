package parser;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import core.IMessage;

import craps.msg.MSGApostarCraps;
import craps.msg.MSGApuesta;
import craps.msg.MSGCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGEstadoCraps;
import craps.msg.MSGJugadorCraps;
import craps.msg.MSGOpcionApuesta;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;
import craps.msg.MSGValorFicha;

public class ParserCraps extends Parser {
	
	private static Logger messageParser = Logger.getLogger("MessageParser");
	private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static ParserCraps instance;
	private static XStream xstream;
	
	private ParserCraps()
	{
		xstream = new XStream(new DomDriver()); 
		
		// MSG CRAPS
		xstream.aliasAttribute(MSGCraps.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCraps.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGCraps.class, "mesa", "mesa");
		
		// ENTRADA CRAPS
		xstream.alias("entradaCraps", MSGEntradaCraps.class);
		
		// SALIDA CRAPS
		xstream.alias("salidaCraps", MSGSalidaCraps.class);
		
		// APOSTAR CRAPS
		xstream.alias("apostarCraps", MSGApostarCraps.class);
		xstream.aliasAttribute(MSGApostarCraps.class, "valorApuesta", "valorApuesta");
		xstream.alias("valorFicha", MSGValorFicha.class);
		xstream.alias("opcionApuesta", MSGOpcionApuesta.class);

		// TIRO CRAPS
		xstream.alias("tiroCraps", MSGTiroCraps.class);
		
		
		// PARSER CRAPS
		xstream.alias("estadoCraps", MSGEstadoCraps.class);
		xstream.alias("jugador", MSGJugadorCraps.class);
		
		
		xstream.alias("apuesta", MSGApuesta.class);
		

	}
	
	public static ParserCraps getInstance()
	{
		if(instance == null)
			instance = new ParserCraps();
		return instance;
	}
	
	public Object parse(IMessage is) throws ParserException
	{	
		try
		{
			messageParser.debug("parseando... " + "\n ------------------- \n" + 
					is.getData() + " ------------------- ");
			Object message; 
			String s = is.getData();
			message = xstream.fromXML(s.trim());
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
		
		messageParser.debug("renderizando: " + "\n ------------------- \n" + 
				imsg.getData() + "\n ------------------- ");
	}
}
