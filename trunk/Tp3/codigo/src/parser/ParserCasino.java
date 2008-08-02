package parser;

import casino.msg.MSGCasino;
import casino.msg.MSGEntradaCasino;
import casino.msg.MSGSalidaCasino;
import casino.msg.estadoCasino.MSGCraps;
import casino.msg.estadoCasino.MSGEstadoCasino;
import casino.msg.estadoCasino.MSGJugador;
import casino.msg.estadoCasino.MSGMesaCraps;
import casino.msg.estadoCasino.MSGObservador;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import craps.msg.MSGProxTiro;
import craps.msg.MSGUltimoTiro;

public class ParserCasino extends Parser {
	
	//private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static ParserCasino instance;
	
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
		xstream.alias("jugador", MSGJugador.class);
		xstream.alias("observador", MSGObservador.class);
		xstream.alias("craps", MSGCraps.class);
		xstream.alias("mesaCraps", MSGMesaCraps.class);
		xstream.aliasAttribute(MSGMesaCraps.class, "id", "id");	
		xstream.alias("proximoTiro", MSGProxTiro.class);
		xstream.alias("ultimoTiro", MSGUltimoTiro.class);
		xstream.aliasAttribute(MSGJugador.class, "nombre", "nombre");
		
		// SALIDA CASINO
		xstream.alias("salidaCasino", MSGSalidaCasino.class);
		
		/*
		xstream.alias("pozos", MSGPozo.class);
		xstream.aliasAttribute(MSGObservador.class, "nombre", "nombre");
		*/
	}
	
	public static ParserCasino getInstance()
	{
		if(instance == null)
			instance = new ParserCasino();
		return instance;
	}
	
}
