package casino;

import org.apache.log4j.Logger;

import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGsetModoDirigido;

/**
 * ManejadorModoDirigido.
 * 
 * @author Grupo2
 *
 */
public class ManejadorModoDirigido implements IServiciosModoDirigido 
{

	private static IServiciosModoDirigido instance;
	private Logger logger = Logger.getLogger(ManejadorModoDirigido.class);
	
	/**
	 * Constructor.
	 */
	private ManejadorModoDirigido(){}

	/**
	 * Obtiene la unica instancia del ManejadorModoDirigido.
	 * 
	 * @return la unica instancia del ManejadorModoDirigido.
	 */
	public static IServiciosModoDirigido getInstance()
	{
		if(instance == null)
			instance = new ManejadorModoDirigido();
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje){
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGSetJugada setearJugada(MSGSetJugada mensaje)
	{
		ManejadorMesa manejador = null;
		
		for (ManejadorMesa m : ManejadorJugador.getInstance().getManejadores())
		{
			if (m.getName().equals(mensaje.getJuego()));
			{
				logger.debug("encontre manejador");
				manejador = m;
			}
		}
		if(manejador == null)
		{
			logger.info("No hay ningun juego registrado con ese nombre");
			mensaje.setAceptado(false);
			mensaje.setDescripcion("No hay ningun juego registrado con ese nombre");
		}
		else
		{
			IMesa mesa = null; 
			mesa = manejador.getMesa(mensaje.getMesa());
			if(mesa == null)
			{
				logger.info("No hay ninguna mesa con el id seleccionado");
				mensaje.setAceptado(false);
				mensaje.setDescripcion("No hay ninguna mesa con el id seleccionado");
			}
			else if( !mesa.isAbierta() )
			{
				logger.info("La mesa esta cerrada, el seteo de una jugada es initil");
				mensaje.setAceptado(false);
				mensaje.setDescripcion("La mesa esta cerrada, el seteo de una jugada es initil");
			}
			else
			{
				SelectorTipoJugadaMD.getInstance().addJugadaSeteada(mesa, mensaje.getTipo());
				logger.info("El seteo de la jugada se completo corectamente");
				mensaje.setAceptado(false);
				mensaje.setDescripcion("El seteo de la jugada se completo corectamente");
			}
		}
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGsetModoDirigido setModoDirigido(MSGsetModoDirigido mensaje)
	{
		return null;
	}

}