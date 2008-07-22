package casino;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGsetModoDirigido;
import casino.msg.estadoCasino.MSGEstadoCasino;

public class ManejadorCasino implements IServiciosCasino {

	private static IServiciosCasino instance;

	/* (non-Javadoc)
	 * @see casino.IServiciosCasino#abrirCasino(casino.msg.MSGAbrirCasino)
	 */
	public MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje){
		return null;
	}

	/*public int calcularMontoAApostar(list<int a , fIcha ficha> lista){
		return 0;
	}*/

	/* (non-Javadoc)
	 * @see casino.IServiciosCasino#cerrarCasino(casino.msg.MSGCerrarCasino)
	 */
	public MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje){
		return null;
	}

	/* (non-Javadoc)
	 * @see casino.IServiciosCasino#estadoCasino(casino.msg.estadoCasino.MSGEstadoCasino)
	 */
	public MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje){
		return null;
	}

	public static IServiciosCasino getInstance(){
		if(instance != null)
			return instance;
		return new ManejadorCasino();
	}

	private ManejadorCasino(){
	}

	/* (non-Javadoc)
	 * @see casino.IServiciosCasino#resetModoDirigido(casino.msg.MSGsetModoDirigido)
	 */
	public void resetModoDirigido(MSGsetModoDirigido unMSG){

	}

	/* (non-Javadoc)
	 * @see casino.IServiciosCasino#setearModoDirigido(casino.msg.MSGResetModoDirigido)
	 */
	public void setearModoDirigido(MSGResetModoDirigido unMSG){

	}

	/*public void validarFichas(List<Ficha> fichas){

	}*/

}