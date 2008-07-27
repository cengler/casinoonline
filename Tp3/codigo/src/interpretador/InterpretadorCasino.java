package interpretador;

import org.apache.log4j.Logger;

import parser.Parser;
import parser.ParserCasino;
import parser.ParserException;
import servicios.SrvAdministracion;
import casino.msg.MSGAbrirCasino;
import core.IMessage;

public class InterpretadorCasino implements IInterpretadorCasino {

	
	private Parser parser;
	private static InterpretadorCasino instance; 
	private Logger logger = Logger.getLogger(InterpretadorCasino.class);
	
	private InterpretadorCasino()
	{
		parser = ParserCasino.getInstance();
	}

	public IMessage interpretar(IMessage mensaje) {
		
		Object mensajeObj = null;
		try {
			mensajeObj = parser.parse(mensaje);
		} catch (ParserException e) {
			logger.error("Error en el parser");
			// TODO Auto-generated catch block
			// ver como responder al error al usuario
			//e.printStackTrace();
		}
		
		if(mensajeObj instanceof MSGAbrirCasino)
		{
			SrvAdministracion.abrirCasino((MSGAbrirCasino)mensajeObj);
		}
		
		// FALTA RESTO
		
		return null;
	}

	public static InterpretadorCasino getInstance() {
		if(instance == null)
			instance = new InterpretadorCasino();
		return instance;
	}

}