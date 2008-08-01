package interpretador;

import org.apache.log4j.Logger;

import parser.Parser;
import parser.ParserAdministracion;
import parser.ParserException;
import servicios.SrvAdministracion;
import casino.msg.MSGAbrirCasino;
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
		MSGAbrirCasino rta = null;
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
		
		if(mensajeObj instanceof MSGAbrirCasino)
		{
			rta = SrvAdministracion.abrirCasino((MSGAbrirCasino)mensajeObj);
		}
		
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