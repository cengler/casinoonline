package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import casino.msg.estadoCasino.IMSGJuego;
import casino.msg.estadoCasino.MSGCraps;
import casino.msg.estadoCasino.MSGEstadoCasino;
import casino.msg.estadoCasino.MSGJugador;
import casino.msg.estadoCasino.MSGMesaCraps;
import casino.msg.estadoCasino.MSGMesaTragamonedas;
import casino.msg.estadoCasino.MSGObservador;
import casino.msg.estadoCasino.MSGPozo;
//import casino.msg.estadoCasino.MSGProximoTiro;
//import casino.msg.estadoCasino.MSGResultado;
import casino.msg.estadoCasino.MSGTragamonedas;
//import casino.msg.estadoCasino.MSGUltimoTiroCraps;
import casino.msg.MSGEntradaCasino;
import casino.msg.MSGSalidaCasino;
import craps.msg.MSGUltimoTiro;
import craps.msg.MSGProxTiro;

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
		xstream.aliasAttribute(MSGEstadoCasino.class, "juegos", "juegos");
		xstream.alias("juegos", IMSGJuego.class);
				
		xstream.alias("tragamonedas", MSGTragamonedas.class);
		xstream.alias("mesaTragamonedas", MSGMesaTragamonedas.class);
		xstream.alias("ultimoTiroTraga", MSGUltimoTiro.class);
		
		//xstream.alias("resultadoTraga", MSGResultado.class);
		
		xstream.alias("craps", MSGCraps.class);
		xstream.alias("mesaCraps", MSGMesaCraps.class);
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
		xstream.aliasAttribute(MSGMesaTragamonedas.class, "id", "id");
		xstream.aliasAttribute(MSGMesaCraps.class, "id", "id");		
				
		
		xstream.alias("entradaCasino", MSGEntradaCasino.class);
		xstream.aliasAttribute(MSGEntradaCasino.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGEntradaCasino.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGEntradaCasino.class, "modoAcceso", "modoAcceso");
		xstream.aliasAttribute(MSGEntradaCasino.class, "saldo", "saldo");
		xstream.aliasAttribute(MSGEntradaCasino.class, "fichasHabilitadas", "fichasHabilitadas");
		xstream.aliasAttribute(MSGEntradaCasino.class, "aceptado", "aceptado");
		xstream.alias("valorFicha", Integer.class);
		
		xstream.alias("salidaCasino", MSGSalidaCasino.class);
		xstream.aliasAttribute(MSGSalidaCasino.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGSalidaCasino.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGSalidaCasino.class, "aceptado", "aceptado");
		
		
		
	
	}
	
	public static ParserCasino getInstance()
	{
		if(instance == null)
			instance = new ParserCasino();
		return instance;
	}
	
/*	public Object parse(IMessage is) throws ParserException
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
*/	
	public Object parse(InputStream is)
	{	
		logger.debug("parseando...");
		Object message = xstream.fromXML(is);
		return message;
		
	}
	
	
	
//	public IMessage renderizar(Object msg) throws ParserException
//	{	
		/*FileOutputStream fos;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		xstream.toXML(msg, fos);;*/
		//TODO
	//	return null;
	//}
	public void renderizar(Object msg, String path) throws FileNotFoundException
	{	
		FileOutputStream fos = new FileOutputStream(path);  
		
		xstream.toXML(msg, fos);
		
	}
}
