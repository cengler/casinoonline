package traga;

import java.util.List;

public class SelectorResTragaModoDirigido implements ISelectorResTraga {

	private static SelectorResTragaModoDirigido instance;

	private SelectorResTragaModoDirigido(){

	}

	public static SelectorResTragaModoDirigido getInstance(){
		if(instance != null)
			instance = new SelectorResTragaModoDirigido();
		return instance;
	}

	public ResultTraga getResult(){
		return null;
	}

	public void setResultDirigido(List<Object> Lista){

	}

}