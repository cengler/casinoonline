package mensajero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

public class FileMessage implements IMessage {

	private File file;
	private String name;
	
	public FileMessage(File file)
	{
		this.file = file;
		this.name = file.getName();
	}
	
	public File getFile()
	{
		return file;
	}

	public InputStream getData() {
		
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is;
	}

	public Date getDate() {
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
	}

	public String getName() {
		return name;
	}
}
