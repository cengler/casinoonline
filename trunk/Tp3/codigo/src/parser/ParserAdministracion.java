package parser;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGResultadoCrapsModo;
import casino.msg.MSGResultadosCrapsModo;
import casino.msg.MSGResultadosModo;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Parser de mensajes apministrativos. 
 * AbrirCasino, CerrarCasino
 * 
 * @author Grupo2. ver 2.0
 *
 */
public class ParserAdministracion extends Parser{
	
	private static ParserAdministracion instance;
	
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
		
		
		
	}
	
	public static ParserAdministracion getInstance()
	{
		if(instance == null)
			instance = new ParserAdministracion();
		return instance;
	}
	

}
