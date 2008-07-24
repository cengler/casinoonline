package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import craps.msg.*;
import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class ParserCraps {
	
	private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static XStream xstream;
	private static ParserCraps instance;
	
	private ParserCraps()
	{
		xstream = new XStream(new DomDriver()); 
		
		xstream.alias("entradaCraps", MSGEntradaCraps.class);
		xstream.aliasAttribute(MSGCraps.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCraps.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGCraps.class, "mesa", "mesa");
		xstream.aliasAttribute(MSGCraps.class, "aceptado", "aceptado");
		xstream.aliasAttribute(MSGCraps.class, "descripcion", "descripcion");
		
		xstream.alias("salidaCraps", MSGSalidaCraps.class);
		xstream.aliasAttribute(MSGCraps.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCraps.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGCraps.class, "mesa", "mesa");
		xstream.aliasAttribute(MSGCraps.class, "aceptado", "aceptado");
		xstream.aliasAttribute(MSGCraps.class, "descripcion", "descripcion");
		
		xstream.alias("apostarCraps", MSGApostarCraps.class);
		xstream.aliasAttribute(MSGCraps.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCraps.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGCraps.class, "mesa", "mesa");
		xstream.aliasAttribute(MSGCraps.class, "aceptado", "aceptado");
		xstream.aliasAttribute(MSGApostarCraps.class, "valorApuesta", "valorApuesta");
		xstream.alias("valorFicha", MSGValorFicha.class);
		xstream.aliasAttribute(MSGValorFicha.class, "cantidad", "cantidad");
		xstream.aliasAttribute(MSGValorFicha.class, "valor", "valor");
		xstream.aliasAttribute(MSGApostarCraps.class, "opcionApuesta", "opcionApuesta");
		xstream.alias("opcionApuesta", MSGOpcionApuesta.class);
		xstream.aliasAttribute(MSGOpcionApuesta.class, "tipoApuesta", "tipoApuesta");
		xstream.aliasAttribute(MSGOpcionApuesta.class, "puntajeApostado", "puntajeApostado");
		
		xstream.alias("tiroCraps", MSGTiroCraps.class);
		xstream.aliasAttribute(MSGCraps.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCraps.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGCraps.class, "mesa", "mesa");
		xstream.aliasAttribute(MSGCraps.class, "aceptado", "aceptado");
		xstream.aliasAttribute(MSGTiroCraps.class, "tipoJugada", "tipoJugada");
		xstream.aliasAttribute(MSGTiroCraps.class, "resultado", "resultado");
		xstream.alias("resultado", MSGResultadoCraps.class);
		
		
		
	}
	
	public static ParserCraps getInstance()
	{
		if(instance == null)
			instance = new ParserCraps();
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
		
		xstream.toXML(msg, fos);
		
	}
}
