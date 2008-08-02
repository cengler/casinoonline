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
		
		// SALIDA CASINO
		xstream.alias("salidaCasino", MSGSalidaCasino.class);
		/*
		
		xstream.aliasAttribute(MSGEstadoCasino.class, "juegos", "juegos");
		xstream.alias("juegos", IMSGJuego.class);

		xstream.aliasAttribute(MSGMesaCraps.class, "jugadores", "jugadores");
		xstream.aliasAttribute(MSGMesaCraps.class, "proximoTiro", "proximoTiro");
		xstream.aliasAttribute(MSGMesaCraps.class, "ultimoTiro", "ultimoTiro");
		xstream.alias("proximoTiro", MSGProxTiro.class);
		xstream.aliasAttribute(MSGProxTiro.class, "tirador", "tirador");
		xstream.aliasAttribute(MSGProxTiro.class, "tiroSalida", "tiroSalida");
		xstream.aliasAttribute(MSGProxTiro.class, "punto", "punto");
					
		xstream.alias("ultimoTiro", MSGUltimoTiro.class);
		xstream.aliasAttribute(MSGUltimoTiro.class, "tirador", "tirador");
		
		xstream.aliasAttribute(MSGUltimoTiro.class, "resultado", "resultado");
			
		
		xstream.alias("pozos", MSGPozo.class);
		xstream.aliasAttribute(MSGJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(MSGObservador.class, "nombre", "nombre");
		xstream.aliasAttribute(MSGMesaCraps.class, "id", "id");		
		
		*/
	}
	
	public static ParserCasino getInstance()
	{
		if(instance == null)
			instance = new ParserCasino();
		return instance;
	}
	
}
