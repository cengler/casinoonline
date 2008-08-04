package servicios;

import org.apache.log4j.Logger;

import core.ImplementationFactory;

import casino.IServiciosCasino;
import casino.IServiciosModoDirigido;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGReporteRankingJugadores;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModo;

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
	 */
	public static MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje){
		
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosModoDirigido.class, true).resetModoDirigido(mensaje);
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
	 * SetearJugada.
	 */
	public static MSGSetJugada setearJugada(MSGSetJugada mensaje){
		
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosModoDirigido.class, true).setearJugada(mensaje);
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
	 * SetModoDirigido.
	 */
	public static MSGSetModo setModoDirigido(MSGSetModo mensaje){
		
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosModoDirigido.class, true).setModoDirigido(mensaje);
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
	 * reporteRanking.
	 */
	public static MSGReporteRankingJugadores reporteRanking(MSGReporteRankingJugadores mensaje){
		
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCasino.class, true).reporteRanking(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(false);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

}