package servicios;

import org.apache.log4j.Logger;

import casino.IServiciosCasino;
import casino.ManejadorModoDirigido;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModo;
import core.ImplementationFactory;

/**
 * Servicios Administracion. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class SrvAdministracion {

	private static Logger logger = Logger.getLogger(SrvAdministracion.class);
	/**
	 * Constructor.
	 */
	private SrvAdministracion(){}

	/**
	 * AbrirCasino.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCasino.class, true).abrirCasino(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(false);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

	/**
	 * CerrarCasino.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCasino.class, true).cerrarCasino(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(false);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

	/**
	 * ResetModoDirigido.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje){
		return ManejadorModoDirigido.getInstance().resetModoDirigido(mensaje);
	}

	/**
	 * SetearJugada.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGSetJugada setearJugada(MSGSetJugada mensaje){
		return ManejadorModoDirigido.getInstance().setearJugada(mensaje);
	}

	/**
	 * SetModoDirigido.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGSetModo setModoDirigido(MSGSetModo mensaje){
		return ManejadorModoDirigido.getInstance().setModoDirigido(mensaje);
	}

}