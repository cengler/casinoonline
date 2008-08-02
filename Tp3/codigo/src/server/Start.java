package server;

import java.util.Date;

import mensajero.MessageListenerAdministracion;

import org.apache.log4j.Logger;

import casino.ManejadorJugador;
import casino.ManejadorModoDirigido;
import core.Mensajero;
import core.MensajeroXArchivos;
import craps.ManejadorMesaCraps;
import craps.SelectorResCrapsModoDirigido;

public class Start {

	Logger logger = Logger.getLogger(Start.class);
	
	Mensajero mCasino = null; 
	Mensajero mCraps = null;
	Mensajero mAdministracion = null; 
	Mensajero mTraga = null; 
	Mensajero mEstadoCraps = null;
	
	public Start()
	{}
	
	public void iniciar(String dir)
	{
		try {
			logger.info("Iniciando servidor...");
			Date d = new Date(); 
			
			// CONFIGURACIONES INICIALES
			// registro de juegos
			ManejadorJugador.getInstance().getManejadores().add(ManejadorMesaCraps.getInstance());
			// registro seteadores de resultado
			ManejadorModoDirigido.getInstance().getSeteadoresRes().add(SelectorResCrapsModoDirigido.getInstance());
			
			logger.debug("Instanciando mensajeros...");
			mAdministracion = new MensajeroXArchivos(dir,"abrirCasino.*|cerrarCasino.*|setModo.*|setJugada.*"); 
			mAdministracion.setListener(new MessageListenerAdministracion()); 
			mAdministracion.openConnection(); 
			
			logger.debug("Iniciando mensajeros...");
			new Thread(mAdministracion).start();
			
			logger.info("Servidor iniciado en: " + (new Date().getTime() - d.getTime()) + " milisegundos");
			
		} 
		catch (Exception e) 
		{
			logger.fatal("El servidor ha encontrado un error grave ", e);
			System.exit(-1);
		}
	}
	
	
	public static void main(String[] args)
	{
		Start s = new Start();
		s.iniciar(args[0]);

	}
}
