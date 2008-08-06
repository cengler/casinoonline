package parser;

import org.apache.log4j.Logger;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGJugador;
import casino.msg.MSGPozo;
import casino.msg.MSGReporteEstadoActual;
import casino.msg.MSGReporteRankingJugadores;
import casino.msg.MSGResultadoCrapsModo;
import casino.msg.MSGResultadosCrapsModo;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import core.IMessage;

/**
 * Parser de mensajes apministrativos. 
 * AbrirCasino, CerrarCasino
 * 
 * @author Grupo2. ver 2.0
 *
 */
public class ParserAdministracion extends Parser{
	
	private static Logger messageParser = Logger.getLogger("MessageParser");
	private static Logger logger = Logger.getLogger(ParserAdministracion.class);
	private static ParserAdministracion instance;
	private static XStream xstream;
	
	private ParserAdministracion()
	{
		xstream = new XStream(new DomDriver()); 
		
		// ABRIR CASINO
		xstream.alias("abrirCasino", MSGAbrirCasino.class);
		// CERRAR
		xstream.alias("cerrarCasino", MSGCerrarCasino.class);
		// SETEAR JUGADA
		xstream.alias("setJugada", MSGSetJugada.class);
		// SETEAR MODO
		xstream.alias("setModo", MSGSetModo.class);
		xstream.alias("resultadosCraps", MSGResultadosCrapsModo.class);
		xstream.alias("resultadoCraps", MSGResultadoCrapsModo.class);
		xstream.aliasAttribute(MSGResultadoCrapsModo.class, "dado1", "dado1");
		xstream.aliasAttribute(MSGResultadoCrapsModo.class, "dado2", "dado2");
		// REPORTE
		xstream.alias("reporteRanking", MSGReporteRankingJugadores.class);
		xstream.alias("jugador", MSGJugador.class);
		xstream.aliasAttribute(MSGJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(MSGJugador.class, "saldo", "saldo");
		
		xstream.alias("reporteEstadoActual", MSGReporteEstadoActual.class);
		xstream.alias("pozosCasino", MSGPozo.class);
		
	}
	
	public static ParserAdministracion getInstance()
	{
		if(instance == null)
			instance = new ParserAdministracion();
		return instance;
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
		messageParser.debug("renderizando: " + "\n ------------------- \n" + 
				imsg.getData() + "\n ------------------- ");
	}
}
