package casino.msg;

import java.util.ArrayList;
import java.util.List;

public class MSGSetModo extends MSGAdministracion {

	private String modo = "";
	private List<MSGResultadosModo> resultados;
	
	public MSGSetModo()
	{
		resultados = new ArrayList<MSGResultadosModo>();
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public List<MSGResultadosModo> getResultados() {
		return resultados;
	}

	public void setResultados(List<MSGResultadosModo> resultados) {
		this.resultados = resultados;
	}
}