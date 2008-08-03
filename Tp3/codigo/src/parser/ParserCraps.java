package parser;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import core.IMessage;

import craps.msg.MSGApostarCraps;
import craps.msg.MSGCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGSalidaCraps;

public class ParserCraps extends Parser {
	
	private static Logger logger = Logger.getLogger(ParserCasino.class);
	private static ParserCraps instance;
	private static XStream xstream;
	
	private ParserCraps()
	{
		xstream = new XStream(new DomDriver()); 
		
		// MSG CRAPS
		xstream.aliasAttribute(MSGCraps.class, "vTerm", "vTerm");
		xstream.aliasAttribute(MSGCraps.class, "usuario", "usuario");
		xstream.aliasAttribute(MSGCraps.class, "mesa", "mesa");
		
		// ENTRADA CRAPS
		xstream.alias("entradaCraps", MSGEntradaCraps.class);
		
		// SALIDA CRAPS
		xstream.alias("salidaCraps", MSGSalidaCraps.class);
		
		// APOSTAR CRAPS
		xstream.alias("apostarCraps", MSGApostarCraps.class);
		xstream.aliasAttribute(MSGApostarCraps.class, "valorApuesta", "valorApuesta");
		
		
		
		
		/*xstream.alias("valorFicha", MSGValorFicha.class);
		xstream.aliasAttribute(MSGValorFicha.class, "cantidad", "cantidad");
		xstream.aliasAttribute(MSGValorFicha.class, "valor", "valor");
		xstream.aliasAttribute(MSGApostarCraps.class, "opcionApuesta", "opcionApuesta");
		xstream.alias("opcionApuesta", MSGOpcionApuesta.class);
		xstream.aliasAttribute(MSGOpcionApuesta.class, "tipoApuesta", "tipoApuesta");
		xstream.aliasAttribute(MSGOpcionApuesta.class, "puntajeApostado", "puntajeApostado");
		
		// TIRAR CRAPS
		xstream.alias("tiroCraps", MSGTiroCraps.class);
		xstream.aliasAttribute(MSGTiroCraps.class, "tipoJugada", "tipoJugada");
		xstream.aliasAttribute(MSGTiroCraps.class, "resultado", "resultado");
		xstream.alias("resultado", MSGResultadoCraps.class);
		
		xstream.alias("estadoMesaCraps", MSGEstadoCraps.class);
		xstream.aliasAttribute(MSGEstadoCraps.class, "jugadores", "jugadores");
		xstream.alias("jugador", MSGJugador.class);
		
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
		xstream.aliasAttribute(MSGOpcionApuesta.class, "puntajeApostado", "puntajeApostado");*/
	}
	
	public static ParserCraps getInstance()
	{
		if(instance == null)
			instance = new ParserCraps();
		return instance;
	}
	
	public Object parse(IMessage is) throws ParserException
	{	
		try
		{
			logger.debug("parseando... " + is.getName() + "\n ------------------- \n" + 
					is.getData() + " ------------------- ");
			Object message; 
			String s = is.getData();
			message = xstream.fromXML(s.trim());
			logger.debug("parseando: " + message + "\n P>------------------ \n" + 
					is.getData() + " P>------------------ ");
			return message;
		}catch(RuntimeException re)
		{
			logger.error("SE RE COLGO! " + re.getMessage() + " "+ re.getCause(), re);
			throw new ParserException(re) ;
		}
	}
	
	/**
	 * Senderiza dentro del IMensaje al mensaje recibido como primer parametro.
	 * 
	 * @param msg mensaje a renderizar
	 * @param imsg IMensaje a llenar con la informacion 
	 * @throws ParserException en caso de un error en el parser
	 */
	public void renderizar(Object msg, IMessage imsg) throws ParserException
	{
		imsg.setData(xstream.toXML(msg));
	}
}