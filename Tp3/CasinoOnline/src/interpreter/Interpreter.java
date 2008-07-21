package interpreter;

import parser.IMSG;
import parser.MSGEstadoCasino;
import parser.ParserCasino;
import mensajero.IMessage;

public class Interpreter 
{
	private static Interpreter interpreter;
	
	private Interpreter()
	{}
	
	public static Interpreter getInstance()
	{
		if(interpreter == null)
			interpreter = new Interpreter();
		return interpreter;
	}
	
	public void interpreta(IMessage msg)
	{
		msg.getName();
		
		IMSG message = ParserCasino.getInstance().parse(msg.getData());
		
		MSGEstadoCasino mes = (MSGEstadoCasino)message;
		
		System.out.println(mes.getUsuario());
	}
}
