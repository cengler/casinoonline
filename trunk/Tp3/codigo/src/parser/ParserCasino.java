package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import casino.msg.MSGAbrirCasino;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class ParserCasino extends Parser{
	
	private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static XStream xstream;
	private static ParserCasino instance;
	
	private ParserCasino()
	{
		xstream = new XStream(new DomDriver()); 
		
		
		//ABRIR CASINO
		xstream.alias("abrirCasino", MSGAbrirCasino.class);
		
		
		
		/*
		
		xstream.alias("estadoCasino", MSGEstadoCasino.class);
		xstream.aliasAttribute(MSGEstadoCasino.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGEstadoCasino.class, "usuario", "usuario");
		xstream.alias("jugador", MSGJugador.class);
		
		xstream.alias("observador", MSGObservador.class);
		xstream.aliasAttribute(MSGEstadoCasino.class, "juegos", "juegos");
		xstream.alias("juegos", IMSGJuego.class);
				
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
		
		*/
		
	
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
			logger.error("No se pudo obtener la informaci�n", e);
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