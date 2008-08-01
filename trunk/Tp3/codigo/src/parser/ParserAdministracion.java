package parser;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Parser de mensajes apministrativos. 
 * AbrirCasino, CerrarCasino
 * 
 * @author Grupo2
 *
 */
public class ParserAdministracion extends Parser{
	
	private static ParserAdministracion instance;
	
	private ParserAdministracion()
	{
		xstream = new XStream(new DomDriver()); 
		
		//ABRIR CASINO
		xstream.alias("abrirCasino", MSGAbrirCasino.class);
		xstream.alias("cerrarCasino", MSGCerrarCasino.class);
		
		
	}
	
	public static ParserAdministracion getInstance()
	{
		if(instance == null)
			instance = new ParserAdministracion();
		return instance;
	}
	

}
