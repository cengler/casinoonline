package mensajero;

import org.apache.log4j.Logger;

public abstract class Mensajero {

	protected boolean con = false;
	protected IMessageListener lis;
	Logger logger = Logger.getLogger(Mensajero.class);
	
	public void closeConnection()
	{
		logger.debug("closeConnection()");
		con = false;
	}
	
	public void openConnection()
	{
		logger.debug("openConnection()");
		con = true;
	}
	
	public abstract void sendMessage(IMessage msg);
	
	public abstract IMessage read();
	
	public void recive() throws Exception
	{
		logger.debug("recive()");
		while(con)
		{
			IMessage msg = read();
			onMessage(msg);
		}
	}
	
	public void setListener(IMessageListener lis)
	{
		logger.debug("setListener() " + lis.getClass());
		this.lis = lis;
	}
	
	public void onMessage(IMessage msg) throws Exception
	{
		if(lis == null)
			throw new Exception("No listerner set");
		lis.onMessage(msg);
	}
}
