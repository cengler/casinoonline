package interpretador;

import org.apache.log4j.Logger;

import parser.Parser;
import parser.ParserAdministracion;
import parser.ParserException;
import servicios.SrvAdministracion;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGAdministracion;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGReporteEstadoActual;
import casino.msg.MSGReporteRankingJugadores;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModo;
import core.IMessage;

/**
 * InterpretadorAdministracion.
 * 
 * @author Grupo2
 *
 */
public class InterpretadorAdministracion implements IInterpretadorCasino {

	private static InterpretadorAdministracion instance; 
	private Parser parser;
	private Logger logger = Logger.getLogger(InterpretadorAdministracion.class);
	
	/**
	 * 
	 * @return
	 */
	public static InterpretadorAdministracion getInstance() {
		if(instance == null)
			instance = new InterpretadorAdministracion();
		return instance;
	}
	
	private InterpretadorAdministracion()
	{
		parser = ParserAdministracion.getInstance();
	}

	public IMessage interpretar(IMessage mensaje) {
		
		Object mensajeObj = null;
		MSGAdministracion rta = null;
		try 
		{
			mensajeObj = parser.parse(mensaje);
		} 
		catch (ParserException e) 
		{
			logger.error("Error en el parser", e);
			// TODO Auto-generated catch block
			// ver como responder al error al usuario
		}
		
		//logger.fatal("FATAL---*-*****> " + ((MSGResultadosCrapsModo)(((MSGSetModo)mensajeObj).getResultados().get(0))).getResultados());
		
		if(mensajeObj instanceof MSGAbrirCasino)
			rta = SrvAdministracion.abrirCasino((MSGAbrirCasino)mensajeObj);
		else if(mensajeObj instanceof MSGCerrarCasino)
			rta = SrvAdministracion.cerrarCasino((MSGCerrarCasino)mensajeObj);
		else if(mensajeObj instanceof MSGSetJugada)
			rta = SrvAdministracion.setearJugada((MSGSetJugada)mensajeObj);
		else if(mensajeObj instanceof MSGSetModo)
			rta = SrvAdministracion.setModoDirigido((MSGSetModo)mensajeObj);
		else if(mensajeObj instanceof MSGReporteRankingJugadores)
			rta = SrvAdministracion.reporteRanking((MSGReporteRankingJugadores)mensajeObj);
		else if(mensajeObj instanceof MSGReporteEstadoActual)
			rta = SrvAdministracion.reporteEstadoActual((MSGReporteEstadoActual)mensajeObj);
			
		logger.debug("rta: ---------> " + rta);
		
		try {
			parser.renderizar(rta, mensaje);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mensaje.setName("rta"+rta.getName()+"02.xml");
		return mensaje;
	}



}