package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class FileMessage implements IMessage {

	private String data;
	private String name;
	private static Logger logger = Logger.getLogger(FileMessage.class);
	
	
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


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	/*public File getFile()
	{
		return file;
	}*/

	/*public InputStream getInputStream() throws NoDataException {
		
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.error("No se ha encontrado el archivo " + name, e);
			throw new NoDataException(e);
		}
		
		return is;
	}*/

	/*public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTo() {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*public OutputStream getOutputStream()
	{
		OutputStream os = null;
		try {
			os = new FileOutputStream(file, false);
		} catch (FileNotFoundException e) {
			logger.error("No se ha encontrado el archivo " + name, e);
			// TODO ex
		}
		return os;
	}*/
}
