package test;

import mensajero.CasinoListener;
import mensajero.MensajeroXArchivos;

public class Main {

		public static void main(String[] args) throws Exception {
			
			MensajeroXArchivos msg = new MensajeroXArchivos("E:\\CasinoTest");
			
			msg.setListener(new CasinoListener());
			msg.openConnection();
			msg.recive();
			msg.closeConnection();
			
		}
}
