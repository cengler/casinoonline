package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * @author cengler
 *
 */
public class ParserCasino {
	
	private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static XStream xstream;
	private static ParserCasino instance;
	
	private ParserCasino()
	{
		xstream = new XStream(new DomDriver()); 
		
		xstream.alias("estadoCasino", MSGEstadoCasino.class);
		xstream.alias("jugador", MSGJugador.class);
		xstream.alias("observador", MSGObservador.class);
		xstream.alias("tragamonedas", MSGTragamonedas.class);
		xstream.alias("mesaTragamonedas", MSGMesaTragamonedas.class);
		xstream.alias("ultimoTiroTragamonedas", MSGUltimoTiroTragamonedas.class);
		xstream.alias("resultadoTragamonedas", MSGResultadoTragamonedas.class);
		xstream.alias("craps", MSGCraps.class);
		xstream.alias("mesaCraps", MSGMesaCraps.class);
		xstream.alias("ultimoTiroCraps", MSGUltimoTiroCraps.class);
		xstream.alias("pozosCasino", MSGPozosCasino.class);
		xstream.aliasAttribute(MSGJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(MSGEstadoCasino.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGEstadoCasino.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGMesaTragamonedas.class, "id", "id");
		xstream.aliasAttribute(MSGMesaCraps.class, "id", "id");
		
		xstream.aliasAttribute(MSGMesaCraps.class, "id", "id");
		
		
		xstream.alias("entradaCasino", MSGEntradaCasino.class);
		xstream.aliasAttribute(MSGEntradaCasino.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGEntradaCasino.class, "usuario", "usuario");
		
	}
	
	public static ParserCasino getInstance()
	{
		if(instance == null)
			instance = new ParserCasino();
		return instance;
	}
	
	public IMSG parse(InputStream is)
	{	
		IMSG message = (IMSG)xstream.fromXML(is);
		return message;
		
	}
	
	public void renderizar(IMSG msg, String path) throws FileNotFoundException
	{	
		FileOutputStream fos = new FileOutputStream(path);  
		
		xstream.toXML(msg, fos);;
		
	}
}
