package core;

import java.io.InputStream;
import java.io.OutputStream;

public interface IMessage 
{
	String getName();
	InputStream getInputStream() throws NoDataException;
	OutputStream getOutputStream();
	
	
	
}