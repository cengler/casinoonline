package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import craps.msg.*;
import org.apache.log4j.Logger;

import casino.msg.estadoCasino.MSGJugador;

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
		
		xstream.alias("estadoMesaCraps", MSGEstadoCraps.class);
		xstream.aliasAttribute(MSGCraps.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCraps.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGCraps.class, "mesa", "mesa");
		xstream.aliasAttribute(MSGEstadoCraps.class, "jugadores", "jugadores");
		xstream.alias("jugador", MSGJugador.class);
		xstream.aliasAttribute(MSGJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(MSGEstadoCraps.class, "proximoTiro", "proximoTiro");
		xstream.alias("proximoTiro", MSGProxTiro.class);
		xstream.aliasAttribute(MSGProxTiro.class, "tirador", "tirador");
		xstream.aliasAttribute(MSGProxTiro.class, "tiroSalida", "tiroSalida");
		xstream.aliasAttribute(MSGProxTiro.class, "punto", "punto");
		xstream.aliasAttribute(MSGEstadoCraps.class, "ultimoTiro", "ultimoTiro");
		xstream.alias("ultimoTiro", MSGUltimoTiro.class);
		xstream.aliasAttribute(MSGUltimoTiro.class, "tirador", "tirador");
		xstream.aliasAttribute(MSGUltimoTiro.class, "resultado", "resultado");
		xstream.aliasAttribute(MSGUltimoTiro.class, "premios", "premios");
		xstream.alias("premio", MSGPremio.class);
		xstream.aliasAttribute(MSGPremio.class, "apostador", "apostador");
		xstream.aliasAttribute(MSGPremio.class, "montoPremioJugada", "montoPremioJugada");
		xstream.aliasAttribute(MSGPremio.class, "montoPremioJugadaFeliz", "montoPremioJugadaFeliz");
		xstream.aliasAttribute(MSGPremio.class, "montoRetenidoJugadaTodosPonen", "montoRetenidoJugadaTodosPonen");
		xstream.aliasAttribute(MSGEstadoCraps.class, "apuestasVigentes", "apuestasVigentes");
		xstream.alias("apuestasVigentes", MSGApuestasVigentes.class);
		xstream.aliasAttribute(MSGApuestasVigentes.class, "apuesta", "apuesta");
		xstream.alias("apuesta", MSGApuesta.class);
		xstream.aliasAttribute(MSGApuesta.class, "apostador", "apostador");
		xstream.aliasAttribute(MSGApuesta.class, "valorApuesta", "valorApuesta");
		xstream.alias("valorFicha", MSGValorFicha.class);
		xstream.aliasAttribute(MSGValorFicha.class, "cantidad", "cantidad");
		xstream.aliasAttribute(MSGValorFicha.class, "valor", "valor");
		xstream.aliasAttribute(MSGApuesta.class, "opcionApuesta", "opcionApuesta");
		xstream.alias("opcionApuesta", MSGOpcionApuesta.class);
		xstream.aliasAttribute(MSGOpcionApuesta.class, "tipoApuesta", "tipoApuesta");
		xstream.aliasAttribute(MSGOpcionApuesta.class, "puntajeApostado", "puntajeApostado");
		
		
		
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