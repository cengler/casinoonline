package mensajero;

import java.io.InputStream;
import java.util.Date;

public interface IMessage {

	InputStream getData();
	
	Date getDate();
	
	String getFrom();
	
	String getTo();
	
	String getName();
}
