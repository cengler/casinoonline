package mensajero;

import java.io.File;

public class MensajeroXArchivos extends Mensajero {

	private File dir;
	
	public MensajeroXArchivos(String dirName) throws Exception
	{
		dir = new File(dirName);
		
		if(!dir.isDirectory())
		{
			throw new Exception("Direcorio invalido");
		}
	}
	
	public IMessage read() {
		
		while(con)
		{
			if(dir.listFiles().length != 0)
			{
				return new FileMessage(dir.listFiles()[0]);
			}
		}
		return null;
	}

	public void sendMessage(IMessage msg) {
		// TODO

	}

}
