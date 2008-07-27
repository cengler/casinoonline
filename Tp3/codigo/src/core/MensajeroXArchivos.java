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
	 * @throws MensajeroException En caso de que el directorio sea invalido
	 */
	public MensajeroXArchivos(String dirName, String regex) throws MensajeroException
	{
		this.dirName = dirName;
		dir = new File(this.dirName);

		if(!dir.isDirectory())
		{
			throw new MensajeroException("Direcorio invalido. No se puede acceder al directorio: " + dirName );
		}
		
		filtro = Pattern.compile(regex);
	}
	
	public IMessage read() {
		
		if(con)
			logger.debug("Esperando mensaje en: " + dirName);
		
		while(con)
		{
			File[] files = dir.listFiles();
			if(files!=null && files.length > 0) // si hay archivos
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
				logger.error("NO se ha podido interrumpir el thread ", e);
			}
		}
		return null;
	}

	public void send(IMessage msg, String name) {
		// TODO
	}
	
	public IMessage onMessage(IMessage msg) throws MensajeroException
	{
		IMessage message;
		
		if(lis == null)
		{
			logger.error("No listerner set");
			throw new MensajeroException("No listerner set");
		}
		message = lis.onMessage(msg);
		
		FileMessage fm = null;
		if(msg instanceof FileMessage)
		{
			fm = (FileMessage)msg;
		}
		else
		{
			logger.error("onMessage debe recibir un FileMessage");
			throw new MensajeroException("onMessage debe recibir un FileMessage");
		}
		
		int retries = 0;
		boolean fileDeleted = false;
		while(retries<MAX_RETRIES && !fileDeleted) {
			fileDeleted = fm.getFile().delete(); 
			if(!fileDeleted) {
				retries++;
				try
				{
					Thread.sleep(500);
				} 
				catch (InterruptedException e)
				{
					logger.info("NO se ha podido interrumpir el thread ", e);
				}
			}
		}
		if(!fileDeleted)
		{
			logger.error("No pudo borrar " + fm.getFile().getName());
			throw new MensajeroException("No pudo borrar " + fm.getFile().getName());
		}
		return message;
	}
	

}
