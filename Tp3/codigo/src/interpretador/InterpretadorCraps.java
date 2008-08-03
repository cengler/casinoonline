package interpretador;

import org.apache.log4j.Logger;

import parser.Parser;
import parser.ParserCraps;
import parser.ParserException;
import servicios.SrvCraps;
import core.IMessage;
import craps.msg.MSGApostarCraps;
import craps.msg.MSGCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;

public class InterpretadorCraps implements IInterpretadorCasino {

	private static Logger logger = Logger.getLogger(InterpretadorCraps.class);
	private static InterpretadorCraps instance;
	private Parser parser;
	
	private InterpretadorCraps()
	{
		parser = ParserCraps.getInstance();
	}
	
	public IMessage interpretar(IMessage mensaje){
		
		Object mensajeObj = null;
		MSGCraps rta = null;
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
		catch(RuntimeException re)
		{
			logger.error("SE RE COLGO!", re);
		}
		
		//logger.fatal("FATAL---*-*****> " + ((MSGResultadosCrapsModo)(((MSGSetModo)mensajeObj).getResultados().get(0))).getResultados());
		
		if(mensajeObj instanceof MSGEntradaCraps)
			rta = SrvCraps.entrarCraps((MSGEntradaCraps)mensajeObj);
		else if(mensajeObj instanceof MSGSalidaCraps)
			rta = SrvCraps.salirCraps((MSGSalidaCraps)mensajeObj);
		else if(mensajeObj instanceof MSGApostarCraps)
			rta = SrvCraps.apostarCraps((MSGApostarCraps)mensajeObj);
		else if(mensajeObj instanceof MSGTiroCraps)
			rta = SrvCraps.tirarCraps((MSGTiroCraps)mensajeObj);
		else
			logger.error("El mensaje no podra ser porcesado por este interpretador"); // TODO

		logger.debug("rta: ---------> " + rta);
		
		try {
			parser.renderizar(rta, mensaje);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mensaje.setName("rta"+rta.getName()+"02"+rta.getVTerm()+".xml");
		return mensaje;
	}

	public static InterpretadorCraps getInstance() {
		if(instance == null)
			instance = new InterpretadorCraps();
		return instance;
	}

}