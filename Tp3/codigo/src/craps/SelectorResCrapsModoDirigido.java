package craps;

import java.util.List;

import casino.ISeteadorResultado;

public class SelectorResCrapsModoDirigido implements ISelectorResCraps, ISeteadorResultado {

	public static String SEL_RES_NAME = "craps";
	
	public SelectorResCrapsModoDirigido(){

	}

	/*public <val, val> getResult(){
		return null;
	}*/

	/**
	 * 
	 * @param lista
	 */
	public void setResultDirigido(List<Object> lista){

	}

	public void getResult() {
		// TODO Auto-generated method stub
		
	}

	public void setResultados(List<Object> lista) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return SEL_RES_NAME;
	}

}