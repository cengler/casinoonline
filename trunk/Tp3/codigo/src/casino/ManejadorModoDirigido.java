package casino;

import java.util.List;

import org.apache.log4j.Logger;

import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGResultados;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModoDirigido;

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
	private List<ISeteadorResultado> seteadoresRes;
	
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
	public MSGSetModoDirigido setModoDirigido(MSGSetModoDirigido mensaje)
	{
		if(mensaje.getModo().equals(MSGSetModoDirigido.DIRIGIDO) )
		{
			if(!Casino.getInstance().isModoNormal())
			{
				logger.info("El casino ya se encuentra en modo " + mensaje.getModo());
				mensaje.setAceptado(false);
				mensaje.setDescripcion("El casino ya se encuentra en modo " + mensaje.getModo());
			}
			else
			{
				for (MSGResultados r : mensaje.getResultados())
				{
					ISeteadorResultado s = getSeteador(r.getName());
					if(s == null)
					{
						logger.info("El manejador de modo dirigido no tiene un seteadorDeRes para el conjunto de resultados " + r.getName());
						mensaje.setAceptado(false);
						mensaje.setDescripcion("El casino no pudo configurar los resultados ");
						return mensaje;
					}
					else
					{
						logger.debug("Seteando resultados para " + r.getName());
						s.setResultados(r.getResultados());
					}
					mensaje.setAceptado(true);
					mensaje.setDescripcion("El casino seteo al casino en modo: " + mensaje.getModo());
				}
				//TODO
				
			}
		}
		return null;
	}
	
	private ISeteadorResultado getSeteador(String setName)
	{
		for (ISeteadorResultado s : seteadoresRes)
		{
			if(s.getName().equals(setName))
				return s; 
		}
		return null;
	}

}