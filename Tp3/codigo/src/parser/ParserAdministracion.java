package parser;

import casino.msg.MSGAbrirCasino;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ParserAdministracion extends Parser{
	
	private static ParserAdministracion instance;
	//private static Logger logger = Logger.getLogger(ParserAdministracion.class);
	
	private ParserAdministracion()
	{
		xstream = new XStream(new DomDriver()); 
		
		xstream.alias("abrirCasino", MSGAbrirCasino.class);
		//xstream.aliasAttribute(MSGAdministracion.class, "aceptado", "aceptado");
		//xstream.aliasAttribute(MSGAdministracion.class, "descripcion", "descripcion");
	}
	
	public static ParserAdministracion getInstance()
	{
		if(instance == null)
			instance = new ParserAdministracion();
		return instance;
	}
	

}
