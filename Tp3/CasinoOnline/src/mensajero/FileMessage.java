package mensajero;

import java.io.File;

public class FileMessage implements IMessage {

	private File file;
	
	public FileMessage(File file)
	{
		this.file = file;
	}
	
	public File getFile()
	{
		return file;
	}
}
