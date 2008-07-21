package casino.msg;

import casino.msg.estadoCasino.MSGEstadoCasino;

public class ManejadorCasino {

	private static ManejadorCasino instance;

	public MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje){
		return null;
	}

	/*public int calcularMontoAApostar(list<int a , fIcha ficha> lista){
		return 0;
	}*/

	public MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje){
		return null;
	}

	public MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje){
		return null;
	}

	public static ManejadorCasino getInstance(){
		if(instance != null)
			return instance;
		return new ManejadorCasino();
	}

	private ManejadorCasino(){
	}

	/**
	 * 
	 * @param unMSG
	 */
	public void resetModoDirigido(MSGsetModoDirigido unMSG){

	}

	public void setearModoDirigido(MSGResetModoDirigido unMSG){

	}

	/*public void validarFichas(List<Ficha> fichas){

	}*/

}