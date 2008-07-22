package implementations;

public class RestaImpl implements IResta {

	private static IResta instance;
	
	private RestaImpl(){}
	
	public static IResta getInstance()
	{
		if(instance == null)
			instance = new RestaImpl();
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see implementations.IResta#restar(int, int)
	 */
	public int restar(int a, int b)
	{
		return a-b;
	}
}
