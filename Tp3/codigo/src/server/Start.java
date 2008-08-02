package server;

import java.util.Date;

import mensajero.MessageListenerAdministracion;
import mensajero.MessageListenerCasino;
import mensajero.MessageListenerCraps;

import org.apache.log4j.Logger;

import casino.ManejadorJugador;
import casino.ManejadorModoDirigido;
import core.Mensajero;
import core.MensajeroXArchivos;
import craps.ManejadorMesaCraps;
import craps.SelectorResCrapsModoDirigido;

public class Start
{
	Logger logger = Logger.getLogger(Start.class);
	
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
			
			// CONFIGURACIONES INICIALES
			// registro de juegos
			ManejadorJugador.getInstance().getManejadores().add(ManejadorMesaCraps.getInstance());
			// registro seteadores de resultado
			ManejadorModoDirigido.getInstance().getSeteadoresRes().add(SelectorResCrapsModoDirigido.getInstance());
			
			logger.debug("Instanciando mensajeros...");
			mAdministracion = new MensajeroXArchivos(dir,"abrirCasino.*|cerrarCasino.*|setModo.*|setJugada.*"); 
			mAdministracion.setListener(new MessageListenerAdministracion()); 
			mAdministracion.openConnection(); 
			
			mCasino = new MensajeroXArchivos(dir,"entradaCasino.*|salidaCasino.*|estadoCasino.*"); 
			mCasino.setListener(new MessageListenerCasino()); 
			mCasino.openConnection(); 
			
			mCraps = new MensajeroXArchivos(dir, "entradaCraps.*|salidaCraps.*|tirarCraps.*|apostarCraps.*");
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
	
	
	public static void main(String[] args)
	{
		Start s = new Start();
		s.iniciar(args[0]);

	}
}
