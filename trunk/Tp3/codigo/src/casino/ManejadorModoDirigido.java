package casino;

import org.apache.log4j.Logger;

import implementations.IResta;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGsetModoDirigido;


public class ManejadorModoDirigido implements IServiciosModoDirigido {

	private static IServiciosModoDirigido instance;
	private Logger logger = Logger.getLogger(ManejadorModoDirigido.class);
	
	private ManejadorModoDirigido(){}

	public static IServiciosModoDirigido getInstance()
	{
		if(instance == null)
			instance = new ManejadorModoDirigido();
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see casino.IServiciosModoDirigido#resetModoDirigido(casino.msg.MSGResetModoDirigido)
	 */
	public MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje){
		return null;
	}

	/* (non-Javadoc)
	 * @see casino.IServiciosModoDirigido#setearJugada(casino.msg.MSGSetJugada)
	 */
	public MSGSetJugada setearJugada(MSGSetJugada mensaje){
		
		logger.debug("setearJugada");
		
		IMesa mesa = null; 
		
		for (ManejadorMesa m : ManejadorJugador.getInstance().getManejadores())
		{
			if (m.getName().equals(mensaje.getJuego()));
			{
				logger.debug("encontre manejador");
				mesa = m.getMesa(mensaje.getMesa());
			}
		}
		
		logger.debug("mesa " + mesa);
		
		
		if(mesa == null)
			logger.fatal("MESA NO EXISTE");
		//TODO throw ERROR
		
		
		
		SelectorTipoJugadaMD.getInstance().addJugadaSeteada(mesa, mensaje.getTipo());
		
		// TODO VER RESPUESTA MAL
		
		return mensaje;
	}

	/* (non-Javadoc)
	 * @see casino.IServiciosModoDirigido#setModoDirigido(casino.msg.MSGsetModoDirigido)
	 */
	public MSGsetModoDirigido setModoDirigido(MSGsetModoDirigido mensaje){
		return null;
	}

}