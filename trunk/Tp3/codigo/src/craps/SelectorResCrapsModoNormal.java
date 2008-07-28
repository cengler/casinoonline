package craps;

public class SelectorResCrapsModoNormal implements ISelectorResCraps {

	private static SelectorResCrapsModoNormal instance;
	
	private SelectorResCrapsModoNormal()
	{
		
	}
	
	public static SelectorResCrapsModoNormal getInstance()
	{
		if(instance == null)
			instance = new SelectorResCrapsModoNormal();
		return instance;
	}

	public ResultadoCraps getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}