package servicios;

import craps.ManejadorMesaCraps;
import craps.msg.MSGApuestaCraps;
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
	public static MSGApuestaCraps apostarCraps(MSGApuestaCraps mensaje){
		return ManejadorMesaCraps.getInstance().apostarCraps(mensaje);
	}

	/**
	 * EntrarCraps.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje){
		return ManejadorMesaCraps.getInstance().entrarCraps(mensaje);
	}

	/**
	 * SalirCraps.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje){
		return ManejadorMesaCraps.getInstance().salirCraps(mensaje);
	}

	/**
	 * TirarCraps.
	 * 
	 * @param mensaje mensaje de pedido del jugadore de craps
	 * @return mensaje de respusta al pedido
	 */
	public static MSGTiroCraps tirarCraps(MSGTiroCraps mensaje){
		return ManejadorMesaCraps.getInstance().tirarCraps(mensaje);
	}

}