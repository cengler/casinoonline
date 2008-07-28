package casino.msg;

import java.util.ArrayList;
import java.util.List;

public class MSGResultadosCraps extends MSGResultados
{
	public static String GAME_NAME = "craps";
	private List<Integer> resultados; 
	
	public MSGResultadosCraps()
	{
		resultados = new ArrayList<Integer>();
	}

	public List<Object> getResultados() {
		return new ArrayList<Object>(resultados);
	}

	public void setResultadosCrasp(List<Object> resultados) {
		this.resultados = new ArrayList<Integer>();
		for (Object i : resultados)
		{
			this.resultados.add((Integer)i);
		}
	}

	public String getName() {
		return GAME_NAME;
	}


	
	
}
