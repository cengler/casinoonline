package casino.msg;

import java.util.ArrayList;
import java.util.List;

public class MSGSetModoDirigido extends MSGModo {

	private String modo = "";
	private List<MSGResultados> resultados;
	
	public MSGSetModoDirigido()
	{
		resultados = new ArrayList<MSGResultados>();
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public List<MSGResultados> getResultados() {
		return resultados;
	}

	public void setResultados(List<MSGResultados> resultados) {
		this.resultados = resultados;
	}
}