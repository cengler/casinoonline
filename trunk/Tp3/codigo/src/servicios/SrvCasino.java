package servicios;

import casino.ManejadorJugador;
import casino.msg.MSGEntradaCasino;
import casino.ManejadorCasino;
import casino.msg.estadoCasino.MSGEstadoCasino;
import casino.msg.MSGSalidaCasino;

/**
 * Servicios Casino. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class SrvCasino {

	/**
	 * Constructor.
	 */
	private SrvCasino(){}

	/**
	 * EntrarCasino.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGEntradaCasino entrarCasino(MSGEntradaCasino mensaje){
		return ManejadorJugador.getInstance().entrarCasino(mensaje);
	}

	/**
	 * EstadoCasino.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje){
		return ManejadorCasino.getInstance().estadoCasino(mensaje);
	}

	/**
	 * SalirCasino.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje){
		return ManejadorJugador.getInstance().salirCasino(mensaje);
	}

}