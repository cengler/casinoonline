package mensajero;

import java.io.File;

import org.apache.log4j.Logger;

public class MensajeroXArchivos extends Mensajero {

	private String dirName;
	private File dir;
	private static final int MAX_RETRIES = 5;
	Logger logger = Logger.getLogger(MensajeroXArchivos.class);
	
	public MensajeroXArchivos(String dirName) throws Exception
	{
		this.dirName = dirName;
		dir = new File(this.dirName);

		if(!dir.isDirectory())
		{
			throw new Exception("Direcorio invalido");
		}
	}
	
	public IMessage read() {
		
		if(con)
			logger.debug("Esperando mensaje en: " + dirName);
		
		while(con)
		{
			File[] files = dir.listFiles();
			if(files!=null && files.length > 0)
			{
				logger.debug("Hay " + files.length + " para procesar.");
				return new FileMessage(files[0]);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void sendMessage(IMessage msg) {
		// TODO

	}
	
	public void onMessage(IMessage msg) throws Exception
	{
		if(lis == null)
			throw new Exception("No listerner set");
		lis.onMessage(msg);
		
		FileMessage fm = (FileMessage)msg;
		
		int retries = 0;
		boolean fileDeleted = false;
		while(retries<MAX_RETRIES && !fileDeleted) {
			fileDeleted = fm.getFile().delete(); 
			if(!fileDeleted) {
				retries++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if(!fileDeleted)
			logger.error("No pudo borrar " + fm.getFile().getName());
	}
	

}
