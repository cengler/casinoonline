package servicios;

import org.apache.log4j.Logger;

import craps.IServiciosCraps;
import craps.msg.MSGApostarCraps;
import craps.msg.MSGCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;

/**
 * Servicios Craps. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class SrvCraps {

	private static Logger logger = Logger.getLogger(SrvCraps.class);
	
	/**
	 * Constructor.
	 */
	private SrvCraps(){}

	/**
	 * ApostarCraps.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGApostarCraps apostarCraps(MSGApostarCraps mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCraps.class, true).apostarCraps(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(MSGCraps.NO);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

	/**
	 * EntrarCraps.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCraps.class, true).entrarCraps(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(MSGCraps.NO);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

	/**
	 * SalirCraps.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCraps.class, true).salirCraps(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(MSGCraps.NO);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

	/**
	 * TirarCraps.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGTiroCraps tirarCraps(MSGTiroCraps mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCraps.class, true).tirarCraps(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(MSGCraps.NO);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

}