package core;

import org.apache.log4j.Logger;

public abstract class Mensajero implements Runnable {

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
	
	public abstract void send(IMessage msg) throws MensajeroException;
	
	public abstract IMessage read() throws MensajeroException;
	
	public void run()
	{
		try {
			logger.debug("recive()");
			while(con)
			{
				IMessage msg = read();
				if(msg != null)
				{
					IMessage rta = onMessage(msg);
					logger.debug("Se va a enviar: " + msg);
					send(rta);
				}
			}
		} catch (MensajeroException e) {
			logger.fatal("Error en en mensajero ", e);
		}
	}
	
	public void setListener(IMessageListener lis)
	{
		logger.debug("setListener() " + lis.getClass());
		this.lis = lis;
	}
	
	public IMessage onMessage(IMessage msg) throws MensajeroException
	{
		if(lis == null)
		{
			logger.error("No listerner set");
			throw new MensajeroException("No listerner set");
		}
		return lis.onMessage(msg);
	}
}
