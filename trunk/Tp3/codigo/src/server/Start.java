package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import mensajero.MessageListenerAdministracion;
import mensajero.MessageListenerCasino;
import mensajero.MessageListenerCraps;

import org.apache.log4j.Logger;

import casino.CasinoException;
import casino.ManejadorJugador;
import casino.ManejadorModoDirigido;
import core.Mensajero;
import core.MensajeroXArchivos;
import craps.ManejadorMesaCraps;
import craps.SelectorResCrapsModoDirigido;

public class Start
{
	Logger logger = Logger.getLogger(Start.class);
	private static String MENSAJERO_PROP = "configuration/mensajeroConfig.properties";
	private static String DIR_CRAPS 	= "dirMensajeroCraps";
	private static String DIR_CASINO 	= "dirMensajeroCasino";
	private static String DIR_ADMIN 	= "dirMensajeroAdministracion";
	private static String FIL_ADMIN 	= "filtroMensajeroAdministracion";
	private static String FIL_CASINO 	= "filtroMensajeroCasino";
	private static String FIL_CRAPS 	= "filtroMensajeroCraps";

	Mensajero mAdministracion = null;
	Mensajero mCasino = null; 
	Mensajero mCraps = null;
	Mensajero mEstadoCraps = null;
	
	public Start()
	{}
	
	public void iniciar(String dir)
	{
		try {
			logger.info("Iniciando servidor...");
			Date d = new Date(); 
			
			
			Properties prop = cargarPropMensajero();
			
			// CONFIGURACIONES INICIALES
			// registro de juegos
			ManejadorJugador.getInstance().getManejadores().add(ManejadorMesaCraps.getInstance());
			// registro seteadores de resultado
			ManejadorModoDirigido.getInstance().getSeteadoresRes().add(SelectorResCrapsModoDirigido.getInstance());
			
			logger.debug("Instanciando mensajeros...");
			mAdministracion = new MensajeroXArchivos(prop.getProperty(DIR_ADMIN), prop.getProperty(FIL_ADMIN)); 
			mAdministracion.setListener(new MessageListenerAdministracion()); 
			mAdministracion.openConnection(); 
			
			mCasino = new MensajeroXArchivos(prop.getProperty(DIR_CASINO), prop.getProperty(FIL_CASINO)); 
			mCasino.setListener(new MessageListenerCasino()); 
			mCasino.openConnection(); 
			
			mCraps = new MensajeroXArchivos(prop.getProperty(DIR_CRAPS), prop.getProperty(FIL_CRAPS));
			mCraps.setListener(new MessageListenerCraps()); 
			mCraps.openConnection();
			
			logger.debug("Iniciando mensajeros...");
			new Thread(mAdministracion).start();
			new Thread(mCasino).start();
			new Thread(mCraps).start();
			
			logger.info("Servidor iniciado en: " + (new Date().getTime() - d.getTime()) + " milisegundos");
			
		} 
		catch (Exception e) 
		{
			logger.fatal("El servidor ha encontrado un error grave ", e);
			System.exit(-1);
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
	
	
	public static void main(String[] args)
	{
		Start s = new Start();
		s.iniciar(args[0]);

	}
}
