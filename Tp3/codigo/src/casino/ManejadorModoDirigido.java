package casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;


import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGResultadosModo;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModo;
import casino.msg.TipoJugada;

/**
 * ManejadorModoDirigido.
 * 
 * @author Grupo2
 *
 */
public class ManejadorModoDirigido implements IServiciosModoDirigido 
{

	private static ManejadorModoDirigido instance;
	private Logger logger = Logger.getLogger(ManejadorModoDirigido.class);
	private List<ISeteadorResultado> seteadoresRes;
	
	/**
	 * Constructor.
	 */
	private ManejadorModoDirigido()
	{
		seteadoresRes = new ArrayList<ISeteadorResultado>();
	}

	/**
	 * Obtiene la unica instancia del ManejadorModoDirigido.
	 * 
	 * @return la unica instancia del ManejadorModoDirigido.
	 */
	public static ManejadorModoDirigido getInstance()
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
			logger.debug("MANEJADOR: " + m.getName() + " " + mensaje.getJuego());
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
				logger.info("La mesa esta cerrada, el seteo de una jugada es inutil");
				mensaje.setAceptado(false);
				mensaje.setDescripcion("La mesa esta cerrada, el seteo de una jugada es initil");
			}
			else
			{
				SelectorTipoJugadaMD.getInstance().addJugadaSeteada(mesa, mensaje.getTipo());
				logger.info("El seteo de la jugada se completo corectamente");
				mensaje.setAceptado(true);
				mensaje.setDescripcion("El seteo de la jugada se completo corectamente");
			}
		}
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGSetModo setModoDirigido(MSGSetModo mensaje)
	{	
		if(mensaje.getModo().equals(MSGSetModo.DIRIGIDO) )
		{
			if(!Casino.getInstance().isModoNormal())
			{
				logger.info("El casino ya se encuentra en modo " + mensaje.getModo());
				mensaje.setAceptado(false);
				mensaje.setDescripcion("El casino ya se encuentra en modo " + mensaje.getModo());
			}
			else
			{
				for (MSGResultadosModo r : mensaje.getResultados()) // TODO bug cuando no me pasan resultados para todos los manejadores
				{
					ISeteadorResultado s = getSeteador(r.getName());
					if(s == null)
					{
						logger.info("El manejador de modo dirigido no tiene un seteadorDeRes para el conjunto de resultados " + r.getName());
						mensaje.setAceptado(false);
						mensaje.setDescripcion("El manejador de modo dirigido no tiene un seteadorDeRes para el conjunto de resultados " + r.getName());
						return mensaje;
					}
					else
					{
						logger.debug("Seteando resultados para " + r.getName() + " resultados: " + r.getResultados());
						try 
						{
							s.borrarResultadosSeteados();
							s.setResultados(r.getResultados());
						} catch (CasinoException e) {
							mensaje.setAceptado(false);
							mensaje.setDescripcion(e.getMessage());
							return mensaje;
						}
					}
				}
				
				Casino.getInstance().setModoNormal(false);
				mensaje.setAceptado(true);
				mensaje.setDescripcion("El casino seteo al casino en modo: " + mensaje.getModo());
				logger.info("El casino seteo al casino en modo: " + mensaje.getModo());
			}
		}
		else if ( mensaje.getModo().equals(MSGSetModo.NORMAL))
		{	
			if(Casino.getInstance().isModoNormal())
			{
				logger.info("El casino ya se encuentra en modo " + mensaje.getModo());
				mensaje.setAceptado(false);
				mensaje.setDescripcion("El casino ya se encuentra en modo " + mensaje.getModo());
			}
			else
			{
				for(ISeteadorResultado s : seteadoresRes)
					s.borrarResultadosSeteados();
				Casino.getInstance().setModoNormal(true);
				mensaje.setAceptado(true);
				mensaje.setDescripcion("El casino seteo al casino en modo: " + mensaje.getModo());
				logger.info("El casino seteo al casino en modo: " + mensaje.getModo());
				
				// BORRO JUGADAS SETEADAS 
				SelectorTipoJugadaMD.getInstance().setJugadasSeteadas(new HashMap<IMesa, TipoJugada>());
				
				// BORRO RESULTADOS
				for(ISeteadorResultado is : seteadoresRes)
				{
					is.borrarResultadosSeteados();
				}
			}
		}
		else
		{
			logger.info("El casino no cuenta con un modo " + mensaje.getModo() + ".");
			mensaje.setAceptado(false);
			mensaje.setDescripcion("El casino no cuenta con un modo " + mensaje.getModo() + ".");
		}
		return mensaje;
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

	public List<ISeteadorResultado> getSeteadoresRes() {
		return seteadoresRes;
	}

	public void setSeteadoresRes(List<ISeteadorResultado> seteadoresRes) {
		this.seteadoresRes = seteadoresRes;
	}
	
	

}