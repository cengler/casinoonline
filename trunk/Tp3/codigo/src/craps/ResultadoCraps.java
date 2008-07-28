package craps;

import org.apache.log4j.Logger;

public class ResultadoCraps {

	private int dado1;
	private int dado2;
	private Logger logger = Logger.getLogger(ResultadoCraps.class);
	
	public ResultadoCraps(int d1, int d2) throws CrapsException
	{	
		if(d1 < 1 || d1 > 6 || d1 < 1 || d1 > 6)
		{
			logger.error("El resultado craps no es valido: " + d1 + " " + d2);
			throw new CrapsException("El resultado craps no es valido: " + d1 + " " + d2);
		}
		dado1 = d1;
		dado2 = d2;	
	}
	
	public int getDado1() {
		return dado1;
	}
	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}
	public int getDado2() {
		return dado2;
	}
	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}

	@Override
	public String toString() {
		return "["+dado1+", " +dado2+"]";
	}
	
	
}
