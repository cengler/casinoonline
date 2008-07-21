package casino;

public class ManejadorCasino {

	private static ManejadorCasino instance;
	
	private ManejadorCasino()
	{}
	
	public ManejadorCasino getInstance()
	{
		if(instance == null)
			instance = new ManejadorCasino();
		return instance;
	}
	
	
}
