package observerCraps;

import parser.ParserCraps;
import parser.ParserException;
import core.FileMessage;
import core.IMessage;
import core.Mensajero;
import core.MensajeroException;
import core.MensajeroXArchivos;
import craps.msg.MSGEstadoCraps;

public class InterpretadorCrapsSalida {

	private static InterpretadorCrapsSalida instance;
	private Mensajero mensajero;
	
	private InterpretadorCrapsSalida()
	{
		try {
			mensajero = new MensajeroXArchivos("", "");
			//mensajero.setListener(lis) TODO
		} catch (MensajeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //TODO
		
	}
	
	public static InterpretadorCrapsSalida getInstance()
	{
		if(instance == null)
			instance = new InterpretadorCrapsSalida();
		return instance;
	}
	
	public void interpretar(MSGEstadoCraps mensaje)
	{
		IMessage msg = new FileMessage("");
		
		try {
			ParserCraps.getInstance().renderizar(mensaje, msg);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mensajero.send(msg);
		} catch (MensajeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
