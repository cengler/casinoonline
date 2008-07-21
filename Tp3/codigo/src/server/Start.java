package server;

import java.util.Date;

import org.apache.log4j.Logger;

import core.Mensajero;
import core.MensajeroXArchivos;

public class Start {

	Logger logger = Logger.getLogger(Start.class);
	
	Mensajero mCasino = null; 
	Mensajero mCraps = null;
	Mensajero mAdministracion = null; 
	Mensajero mTraga = null; 
	Mensajero mEstadoCraps = null;
	
	public Start()
	{}
	
	public void iniciar()
	{
		try {
			logger.info("Iniciando servidor...");
			Date d = new Date(); 
			
			logger.debug("Instanciando mensajeros...");
			mCasino = new MensajeroXArchivos("C:\\"); 
			mCraps = new MensajeroXArchivos("C:\\"); 
			mAdministracion = new MensajeroXArchivos("C:\\"); 
			mTraga = new MensajeroXArchivos("C:\\"); 
			mEstadoCraps = new MensajeroXArchivos("C:\\"); 
			
			logger.debug("Iniciando mensajeros...");
			new Thread(mCasino).start();
			new Thread(mCraps).start();
			new Thread(mAdministracion).start();
			new Thread(mTraga).start();
			new Thread(mEstadoCraps).start();
			
			logger.info("Servidor iniciado en: " + (new Date().getTime() - d.getTime()) + " millisegundos");
			
		} catch (Exception e) {
			logger.fatal("El servidor ha encontrado un error grave ", e);
			System.exit(-1);
		}
	}
	
	
	public static void main(String[] args)
	{
		Start s = new Start();
		s.iniciar();

	}
}
