package interpretador;

import org.apache.log4j.Logger;

import parser.Parser;
import parser.ParserCasino;
import parser.ParserException;
import servicios.SrvCasino;
import casino.msg.MSGCasino;
import casino.msg.MSGEntradaCasino;
import casino.msg.MSGEstadoCasino;
import casino.msg.MSGSalidaCasino;
import core.IMessage;

public class InterpretadorCasino implements IInterpretadorCasino
{
	private Parser parser;
	private static InterpretadorCasino instance; 
	private Logger logger = Logger.getLogger(InterpretadorCasino.class);
	
	private InterpretadorCasino()
	{
		parser = ParserCasino.getInstance();
	}

	public IMessage interpretar(IMessage mensaje)
	{
		Object mensajeObj = null;
		MSGCasino rta = null;
		String nombreArchivo = mensaje.getName();
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
		
		logger.debug("TTT"  + mensajeObj);
		//logger.fatal("FATAL---*-*****> " + ((MSGResultadosCrapsModo)(((MSGSetModo)mensajeObj).getResultados().get(0))).getResultados());
		
		if(mensajeObj instanceof MSGEntradaCasino)
			rta = SrvCasino.entrarCasino((MSGEntradaCasino)mensajeObj);
		else if(mensajeObj instanceof MSGSalidaCasino)
			rta = SrvCasino.salirCasino((MSGSalidaCasino)mensajeObj);
		else if(mensajeObj instanceof MSGEstadoCasino)
			rta = SrvCasino.estadoCasino((MSGEstadoCasino)mensajeObj);

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

	public static InterpretadorCasino getInstance() {
		if(instance == null)
			instance = new InterpretadorCasino();
		return instance;
	}

}