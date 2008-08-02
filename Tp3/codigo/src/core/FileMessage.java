package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * FileMessage. Representa un mensaje que llega el casino y es entregado al interpretador.
 * Esta implementacion de IMessage, obtiene la informacion de un archivo.
 * 
 * @author Grupo2
 *
 */
public class FileMessage implements IMessage {

	private String data;
	private String name;
	private static Logger logger = Logger.getLogger(FileMessage.class);
	
	/**
	 * Constructor.
	 * 
	 * @param file Archivo del cuan obtener la informacion.
	 * @throws MensajeroException En caso de tener problemas con el archivo. (Lectura)
	 */
	public FileMessage(File file) throws MensajeroException
	{
		try {
			InputStream is = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			data = sb.toString();
			name = file.getName();
		} catch (Exception e) 
		{
			logger.error("No se ha podido leer el archivo: " + file.getName() + " por la sig razon: " + e.getMessage());
			throw new MensajeroException("No se ha podido leer el archivo: " + file.getName() + " por la sig razon: " + e.getMessage(), e);
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	public String getData() {
		return data;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setName(String name) {
		this.name = name;
	}
}
