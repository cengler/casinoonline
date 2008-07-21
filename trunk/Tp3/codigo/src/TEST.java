import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import casino.msg.estadoCasino.MSGEstadoCasino;

import parser.ParserCasino;

public class TEST {

	
	
	public static void main(String[] args) {
		
		
		InputStream is;
		try 
		{
			is = new FileInputStream("F:\\- 21-07-08\\TPPP\\Tp3\\codigo\\xml\\estadoCasino.xml");
			MSGEstadoCasino msg = (MSGEstadoCasino)ParserCasino.getInstance().parse(is);
			
			ParserCasino.getInstance().renderizar(msg, "F:\\- 21-07-08\\TPPP\\Tp3\\codigo\\xml\\estadoCasinoP.xml");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
