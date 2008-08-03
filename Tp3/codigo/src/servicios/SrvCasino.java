package servicios;

import org.apache.log4j.Logger;

import casino.IServiciosCasino;
import casino.IServiciosJugador;
import casino.msg.MSGEntradaCasino;
import casino.msg.MSGEstadoCasino;
import casino.msg.MSGSalidaCasino;

/**
 * Servicios Casino. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class SrvCasino {

	private static Logger logger = Logger.getLogger(SrvCasino.class);
	/**
	 * Constructor.
	 */
	private SrvCasino(){}

	/**
	 * EntrarCasino.
	 */
	public static MSGEntradaCasino entrarCasino(MSGEntradaCasino mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosJugador.class, true).entrarCasino(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(MSGEntradaCasino.NO);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

	/**
	 * EstadoCasino.
	 */
	public static MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje){
		
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosCasino.class, true).estadoCasino(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(MSGEntradaCasino.NO);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

	/**
	 * SalirCasino.
	 */
	public static MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje)
	{
		try 
		{
			return ImplementationFactory.getImplementation(IServiciosJugador.class, true).salirCasino(mensaje);
		} 
		catch (Exception e) 
		{
			logger.error(e);
			mensaje.setAceptado(MSGEntradaCasino.NO);
			mensaje.setDescripcion(e.getMessage());
		}
		return mensaje;
	}

}