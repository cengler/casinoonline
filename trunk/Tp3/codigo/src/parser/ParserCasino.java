package parser;

import org.apache.log4j.Logger;

import casino.msg.MSGCasino;
import casino.msg.MSGEntradaCasino;
import casino.msg.MSGEstadoCasino;
import casino.msg.MSGCrapsEstado;
import casino.msg.MSGEstadoJugador;
import casino.msg.MSGMesaCraps;
import casino.msg.MSGObservador;
import casino.msg.MSGSalidaCasino;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import core.IMessage;

import craps.msg.MSGProxTiro;
import craps.msg.MSGUltimoTiro;

public class ParserCasino extends Parser {
	
	private static Logger messageParser = Logger.getLogger("MessageParser");
	private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static ParserCasino instance;
	private static XStream xstream;
	
	private ParserCasino()
	{
		xstream = new XStream(new DomDriver()); 
		
		// MSGCasino
		xstream.aliasAttribute(MSGCasino.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCasino.class, "usuario", "usuario");

		// ENTRADA CASINO  TODO FALTAN PARTES
		xstream.alias("entradaCasino", MSGEntradaCasino.class);

		// ESTADO CASINO
		xstream.alias("estadoCasino", MSGEstadoCasino.class);
		xstream.alias("jugador", MSGEstadoJugador.class);
		xstream.alias("observador", MSGObservador.class);
		xstream.alias("craps", MSGCrapsEstado.class);
		xstream.alias("mesaCraps", MSGMesaCraps.class);
		xstream.aliasAttribute(MSGMesaCraps.class, "id", "id");	
		xstream.alias("proximoTiro", MSGProxTiro.class);
		xstream.alias("ultimoTiro", MSGUltimoTiro.class);
		xstream.aliasAttribute(MSGEstadoJugador.class, "nombre", "nombre");
		
		// SALIDA CASINO
		xstream.alias("salidaCasino", MSGSalidaCasino.class);
		
		/*
		xstream.alias("pozos", MSGPozo.class);
		xstream.aliasAttribute(MSGObservador.class, "nombre", "nombre");
		*/
	}
	
	public Object parse(IMessage is) throws ParserException
	{	
		try
		{
			messageParser.debug("parseando... " + is.getName() + "\n ------------------- \n" + 
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
	}
	
	public static ParserCasino getInstance()
	{
		if(instance == null)
			instance = new ParserCasino();
		return instance;
	}
	
}
