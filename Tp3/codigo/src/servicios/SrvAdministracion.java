package servicios;

import casino.ManejadorModoDirigido;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGsetModoDirigido;
import casino.ManejadorCasino;

/**
 * Servicios Administracion. Ver 1.0
 * 
 * @author Grupo2
 *
 */
public class SrvAdministracion {

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
	public static MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje){
		return ManejadorCasino.getInstance().abrirCasino(mensaje);
	}

	/**
	 * CerrarCasino.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje){
		return ManejadorCasino.getInstance().cerrarCasino(mensaje);
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
	public static MSGsetModoDirigido setModoDirigido(MSGsetModoDirigido mensaje){
		return ManejadorModoDirigido.getInstance().setModoDirigido(mensaje);
	}

}