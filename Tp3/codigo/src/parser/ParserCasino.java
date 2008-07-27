package parser;

import org.apache.log4j.Logger;

import casino.msg.estadoCasino.MSGCraps;
import casino.msg.estadoCasino.MSGEstadoCasino;
import casino.msg.estadoCasino.MSGJugador;
import casino.msg.estadoCasino.MSGMesaCraps;
import casino.msg.estadoCasino.MSGMesaTragamonedas;
import casino.msg.estadoCasino.MSGObservador;
import casino.msg.estadoCasino.MSGPozo;
import casino.msg.estadoCasino.MSGProximoTiro;
import casino.msg.estadoCasino.MSGResultado;
import casino.msg.estadoCasino.MSGTragamonedas;
import casino.msg.estadoCasino.MSGUltimoTiro;
import casino.msg.estadoCasino.MSGUltimoTiroCraps;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import core.IMessage;
import core.NoDataException;

public class ParserCasino extends Parser{
	
	private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static XStream xstream;
	private static ParserCasino instance;
	
	private ParserCasino()
	{
		xstream = new XStream(new DomDriver()); 
		
		xstream.alias("estadoCasino", MSGEstadoCasino.class);
		xstream.aliasAttribute(MSGEstadoCasino.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGEstadoCasino.class, "usuario", "usuario");
		xstream.alias("jugador", MSGJugador.class);
		xstream.alias("observador", MSGObservador.class);
		
		xstream.alias("tragamonedas", MSGTragamonedas.class);
		xstream.alias("mesaTragamonedas", MSGMesaTragamonedas.class);
		xstream.alias("ultimoTiroTraga", MSGUltimoTiro.class);
		
		xstream.alias("resultadoTraga", MSGResultado.class);
		xstream.alias("craps", MSGCraps.class);
		xstream.alias("mesaCraps", MSGMesaCraps.class);
		xstream.alias("proximoTiro", MSGProximoTiro.class);
		xstream.alias("ultimoTiroCraps", MSGUltimoTiroCraps.class);
		xstream.alias("pozosCasino", MSGPozo.class);
		xstream.aliasAttribute(MSGJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(MSGObservador.class, "nombre", "nombre");
		xstream.aliasAttribute(MSGMesaTragamonedas.class, "id", "id");
		xstream.aliasAttribute(MSGMesaCraps.class, "id", "id");		
	}
	
	public static ParserCasino getInstance()
	{
		if(instance == null)
			instance = new ParserCasino();
		return instance;
	}
	
	public Object parse(IMessage is) throws ParserException
	{	
		logger.debug("parseando...");
		Object message;
		try {
			message = xstream.fromXML(is.getInputStream());
		} catch (NoDataException e) {
			logger.error("No se pudo obtener la información", e);
			throw new ParserException(e);
		}
		
		return message;
		
	}
	
	public IMessage renderizar(Object msg) throws ParserException
	{	
		/*FileOutputStream fos;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		xstream.toXML(msg, fos);;*/
		//TODO
		return null;
	}
}
