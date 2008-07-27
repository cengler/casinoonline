package servicios;

import java.io.IOException;

import casino.IServiciosCasino;
import casino.ManejadorModoDirigido;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGSetModoDirigido;
import core.ImplementationFactory;

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
		try {
			return ImplementationFactory.getImplementation(IServiciosCasino.class, true).abrirCasino(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * CerrarCasino.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje){
		try {
			return ImplementationFactory.getImplementation(IServiciosCasino.class, true).cerrarCasino(mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	public static MSGSetModoDirigido setModoDirigido(MSGSetModoDirigido mensaje){
		return ManejadorModoDirigido.getInstance().setModoDirigido(mensaje);
	}

}