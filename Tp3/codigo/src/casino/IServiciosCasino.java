package casino;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGsetModoDirigido;
import casino.msg.estadoCasino.MSGEstadoCasino;

public interface IServiciosCasino {

	public abstract MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje);

	public abstract MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje);

	public abstract MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje);

	/**
	 * 
	 * @param unMSG
	 */
	public abstract void resetModoDirigido(MSGsetModoDirigido unMSG);

	public abstract void setearModoDirigido(MSGResetModoDirigido unMSG);

}