package craps;

import java.util.Random;

import org.apache.log4j.Logger;

public class SelectorResCrapsModoNormal implements ISelectorResCraps {

	private static Logger logger = Logger.getLogger(SelectorResCrapsModoNormal.class);
	private static SelectorResCrapsModoNormal instance;
	
	private SelectorResCrapsModoNormal(){}
	
	public static SelectorResCrapsModoNormal getInstance()
	{
		if(instance == null)
			instance = new SelectorResCrapsModoNormal();
		return instance;
	}

	public ResultadoCraps getResult() 
	{	
		ResultadoCraps res = null;
		Random generator = new Random();
		int dado1 = generator.nextInt(6) + 1;
		int dado2 = generator.nextInt(6) + 1;
		try {
			 res = new ResultadoCraps(dado1, dado2);
		} catch (CrapsException e) {
			logger.fatal("MAL CODIFICADO EL RANDOM");
		}
		return res;
	}
}