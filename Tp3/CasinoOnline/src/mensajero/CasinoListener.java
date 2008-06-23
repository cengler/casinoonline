package mensajero;

public class CasinoListener implements IMessageListener {

	public void onMessage(IMessage msg) 
	{
		FileMessage fm = (FileMessage)msg ;
		System.out.println((fm.getFile().getName()));
		fm.getFile().delete();

	}

}
