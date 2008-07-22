package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import casino.msg.estadoCasino.*;
import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ParserCasino {
	
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
	
	public Object parse(InputStream is)
	{	
		logger.debug("parseando...");
		Object message = xstream.fromXML(is);
		return message;
		
	}
	
	public void renderizar(Object msg, String path) throws FileNotFoundException
	{	
		FileOutputStream fos = new FileOutputStream(path);  
		
		xstream.toXML(msg, fos);;
		
	}
}
