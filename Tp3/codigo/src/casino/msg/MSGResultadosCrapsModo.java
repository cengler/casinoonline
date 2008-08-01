package casino.msg;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class MSGResultadosCrapsModo extends MSGResultadosModo
{
	public static String GAME_NAME = "craps";
	private List<MSGResultadoModo> resultados; 
	private Logger logger = Logger.getLogger(MSGResultadosCrapsModo.class);
	
	public MSGResultadosCrapsModo()
	{
		resultados = new ArrayList<MSGResultadoModo>();
	}

	public List< MSGResultadoModo > getResultados() {
		return resultados;
	}

	public void setResultados(List<MSGResultadoModo> resultados) 
	{
		logger.debug("setResultados");
		
		/*this.resultados = new ArrayList<MSGResultadoCrapsModo>();
		for (Object i : resultados)
		{
			logger.debug("Res: " + i);
			this.resultados.add((MSGResultadoCrapsModo)i);
		}*/
		this.resultados = resultados;
	}

	public String getName() {
		return GAME_NAME;
	}


	
	
}
