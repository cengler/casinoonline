package observerCraps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import casino.CasinoException;
import mensajero.MessageListenerCrapsOut;
import parser.ParserCraps;
import parser.ParserException;
import core.FileMessage;
import core.IMessage;
import core.Mensajero;
import core.MensajeroException;
import core.MensajeroXArchivos;
import craps.msg.MSGEstadoCraps;

public class InterpretadorCrapsSalida {

	private static Logger logger = Logger.getLogger(InterpretadorCrapsSalida.class);
	private static String MENSAJERO_PROP = "configuration/mensajeroConfig.properties";
	private static InterpretadorCrapsSalida instance;
	private Mensajero mensajero;
	private static String DIR_CRAPS_SAL = "dirMensajeroCrapsSalida";
	private static String FIL_CRAPS_SAL = "fittroMensajeroCrapsSalida";
	
	private InterpretadorCrapsSalida()
	{
		try {
			Properties prop = cargarPropMensajero();
			
			mensajero = new MensajeroXArchivos(prop.getProperty(DIR_CRAPS_SAL), prop.getProperty(FIL_CRAPS_SAL));
			
			mensajero.setListener(new MessageListenerCrapsOut());
		} catch (Exception e) {
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
		IMessage msg = new FileMessage();
		
		try {
			ParserCraps.getInstance().renderizar(mensaje, msg);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			msg.setName("rta"+mensaje.getName()+"02"+mensaje.getVTerm()+".xml");
			mensajero.send(msg);
		} catch (MensajeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Properties cargarPropMensajero() throws CasinoException 
	{
		Properties properties = new Properties();
		InputStream is = null;
		try {
			logger.debug("Va a leer las prop de Mensajero del archivo " + MENSAJERO_PROP);
			is = new FileInputStream(MENSAJERO_PROP);
			if(is!=null)
				properties.load(is);
			else
			{
				logger.debug("Propiedades leidas: ");
				for(Object o : properties.keySet())
					logger.debug("\t" + o.toString() + " = " + properties.getProperty(o.toString()));
			}
		} 
		catch (Exception e)
		{
			logger.error("El archivo: " + MENSAJERO_PROP + " no se encuentra.");
			throw new CasinoException(e);
		}
		finally
		{
			try {
				is.close();
			} catch (IOException e) {
				logger.debug("No se pude cerrar el archivo");
			}
		}
		return properties;
	}
}
