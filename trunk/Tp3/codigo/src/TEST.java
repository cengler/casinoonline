import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import parser.parserCraps;
import craps.msg.MSGEntradaCraps;

public class TEST {

	
	
	public static void main(String[] args) {
		
		
	/*	InputStream is;
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
		*/
		InputStream is1;
		try 
		{
			is1 = new FileInputStream("D:/casino/codigo/xml/entradaCraps.xml");
			MSGEntradaCraps msg = (MSGEntradaCraps)parserCraps.getInstance().parse(is1);
			
			parserCraps.getInstance().renderizar(msg, "D:/casino/codigo/xml/entradaCrapsP.xml");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	
}
