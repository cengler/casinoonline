package test;

import java.io.FileNotFoundException;

import parser.ParserCasino;
import mensajero.CasinoListener;
import mensajero.MensajeroXArchivos;

public class Main {

		public static void main(String[] args) throws Exception {
			
			testMensajero();
			
			//testParser();
			
			//testParserWrite();
		}
		
		public static void testMensajero() throws Exception
		{
			MensajeroXArchivos msg = new MensajeroXArchivos("D:\\Casino");
			
			msg.setListener(new CasinoListener());
			msg.openConnection();
			msg.recive();
			
		}
		
		@SuppressWarnings("unused")
		private static void testParser() throws FileNotFoundException
		{
			ParserCasino pc = ParserCasino.getInstance();
			//MSGEstadoCasino msgEC = (MSGEstadoCasino) pc.parse("H:/TPINGE/TPPP/Tp3/CasinoOnline/src/xml/entradaCasino.xml");
			
			//System.out.println(msgEC);
			
			//System.out.println(msgEC.getJugadores().get(0).getNombre());
		}
		
		@SuppressWarnings("unused")
		private static void testParserWrite() throws FileNotFoundException
		{
			ParserCasino pc = ParserCasino.getInstance();
			//MSGEntradaCasino msgEC = (MSGEntradaCasino) pc.parse("F:/TPINGE/TPPP/Tp3/CasinoOnline/src/xml/entrarCasino.xml");

			//pc.renderizar(msgEC, "F:/TPINGE/TPPP/Tp3/CasinoOnline/src/xmlParseados/entrarCasino.xml");
		}
}
