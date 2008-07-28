package casino.msg;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class MSGResultadosCraps extends MSGResultados
{
	public static String GAME_NAME = "craps";
	private List<MSGResultadoCraps> resultados; 
	private Logger logger = Logger.getLogger(MSGResultadosCraps.class);
	
	public MSGResultadosCraps()
	{
		resultados = new ArrayList<MSGResultadoCraps>();
	}

	public List< ? > getResultados() {
		return resultados;
	}

	public void setResultados(List< ? > resultados) 
	{
		logger.debug("setResultados");
		
		this.resultados = new ArrayList<MSGResultadoCraps>();
		for (Object i : resultados)
		{
			logger.debug("Res: " + i);
			this.resultados.add((MSGResultadoCraps)i);
		}
	}

	public String getName() {
		return GAME_NAME;
	}


	
	
}
