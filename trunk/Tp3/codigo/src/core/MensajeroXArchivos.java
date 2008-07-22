package core;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class MensajeroXArchivos extends Mensajero {

	private String dirName;
	private File dir;
	private Pattern filtro;
	private static final int MAX_RETRIES = 5;
	private static final int SLEEP_TIME = 500;
	Logger logger = Logger.getLogger(MensajeroXArchivos.class);
	
	/**
	 * Constructor.
	 * 
	 * @param dirName Directorio que acturá como mailbox
	 * @param regex Expresion regular para filtar los mensajes que le corresponden a este mensajero
	 * @throws Exception En caso de que el directorio sea invalido
	 */
	public MensajeroXArchivos(String dirName, String regex) throws Exception
	{
		this.dirName = dirName;
		dir = new File(this.dirName);

		if(!dir.isDirectory())
		{
			throw new Exception("Direcorio invalido. No se puede acceder al directorio: " + dirName );
		}
		
		filtro = Pattern.compile(regex);
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
				for ( File f : files )
				{
					Matcher m = filtro.matcher(f.getName());
					if( m.matches() )
						return new FileMessage(f);
				}
			}
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void send(IMessage msg, String name) {
		// TODO

	}
	
	public void onMessage(IMessage msg)
	{
		if(lis == null)
			logger.error("No listerner set");
			//throw new Exception("No listerner set");
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
