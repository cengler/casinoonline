package mensajero;

public abstract class Mensajero {

	protected boolean con = false;
	private IMessageListener lis;
	
	public void closeConnection()
	{
		con = false;
	}
	
	public void openConnection()
	{
		con = true;
	}
	
	public abstract void sendMessage(IMessage msg);
	
	public abstract IMessage read();
	
	public void recive() throws Exception
	{
		while(con)
		{
			IMessage msg = read();
			onMessage(msg);
		}
	}
	
	public void setListener(IMessageListener lis)
	{
		this.lis = lis;
	}
	
	public void onMessage(IMessage msg) throws Exception
	{
		if(lis == null)
			throw new Exception("No listerner set");
		lis.onMessage(msg);
	}
}
