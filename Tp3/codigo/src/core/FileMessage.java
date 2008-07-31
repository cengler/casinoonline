package core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class FileMessage implements IMessage {

	private File file;
	private InputStream is;
	//private OutputStream os;
	private String name;
	private Logger logger = Logger.getLogger(FileMessage.class);
	
	public FileMessage(File file)
	{
		// TODO createTempFile(arg0, arg1) FILE.
		int archLargo = (int) file.length();
		byte[] buffer = new byte[archLargo];
		is = new ByteArrayInputStream(buffer) ;
		this.file = file;
		this.name = file.getName();
	}
	
	public File getFile()
	{
		return file;
	}

	public InputStream getInputStream() throws NoDataException {
		
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.error("No se ha encontrado el archivo " + name, e);
			throw new NoDataException(e);
		}
		
		return is;
	}

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

	public String getName() {
		return name;
	}

	public OutputStream getOutputStream()
	{
		OutputStream os = null;
		try {
			os = new FileOutputStream(file, false);
		} catch (FileNotFoundException e) {
			logger.error("No se ha encontrado el archivo " + name, e);
			// TODO ex
		}
		return os;
	}
}
