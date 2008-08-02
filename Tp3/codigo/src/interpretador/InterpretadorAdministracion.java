package interpretador;

import org.apache.log4j.Logger;

import parser.Parser;
import parser.ParserAdministracion;
import parser.ParserException;
import servicios.SrvAdministracion;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGAdministracion;
import casino.msg.MSGCerrarCasino;
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
		String nombreArchivo = mensaje.getName();
		try 
		{
			mensajeObj = parser.parse(mensaje);
		} 
		catch (ParserException e) 
		{
			logger.error("Error en el parser");
			// TODO Auto-generated catch block
			// ver como responder al error al usuario
		}
		catch(RuntimeException re)
		{
			logger.error("SE RE COLGO!", re);
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
		

			
		logger.debug("rta: ---------> " + rta);
		
		try {
			parser.renderizar(rta, mensaje);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mensaje.setName("rta"+nombreArchivo);
		return mensaje;
	}



}