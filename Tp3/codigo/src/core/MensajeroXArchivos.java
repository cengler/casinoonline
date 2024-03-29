package core;

import java.io.File;
import java.io.FileWriter;
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
	 * @param dirName Directorio que actur� como mailbox
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
	
	public IMessage read() throws MensajeroException {
		
		if(con)
			logger.debug("Esperando mensaje en: " + dirName);
		
		while(con)
		{
			File[] files = dir.listFiles();
			if(files!=null && files.length > 0) // si hay archivos
			{
				for ( File f : files )
				{
					Matcher m = filtro.matcher(f.getName());
					if( m.matches() )
					{
						
						FileMessage fm = null;
						try {
							fm = new FileMessage();
							fm.read(f);
						} catch (MensajeroException e) {
							logger.error(e);
							throw e;
						}

						int retries = 0;
						boolean fileDeleted = false;
						while(retries<MAX_RETRIES && !fileDeleted) {
							fileDeleted = f.delete(); 
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
							logger.error("No pudo borrar " + f.getName()); 
							throw new MensajeroException("No pudo borrar " + f.getName());
						}
						return fm;
					}
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

	public void send(IMessage msg) throws MensajeroException {
		
		try {
			FileWriter fr = new FileWriter(dirName+"/"+msg.getName());
			fr.write(msg.getData());
			fr.close();
			logger.debug("MENSAJE ENVIADO");
		} catch (Exception e) {
			logger.error("ERROR EN SEND: ",e);
			throw new MensajeroException("Error al enviar el archivo: " + msg.getName());
		}
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
		return message;
	}
	

}
