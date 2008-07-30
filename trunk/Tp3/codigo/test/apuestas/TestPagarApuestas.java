package apuestas;

import org.apache.log4j.Logger;

import casino.Jugador;
import casino.TipoJugada;

import craps.ApuestaCraps;
import craps.CrapsException;
import craps.ManejadorDeApuestas;
import craps.ResultadoCraps;

public class TestPagarApuestas {

	public static Logger logger = Logger.getLogger(TestPagarApuestas.class);

	public static void main(String[] args) 
	{	
		try {
			pagarApuestas();
		} catch (CrapsException e) {
			logger.fatal("ERROR FATAL EN EL TEST: ", e);
		}

	}
	
	public static void pagarApuestas() throws CrapsException
	{
		ManejadorDeApuestas man = new ManejadorDeApuestas();
		man.pagarApuestas(TipoJugada.feliz, new ResultadoCraps(4, 4));
		
		Jugador pepe = new Jugador();
		ApuestaCraps ap1 = new ApuestaCraps(pepe, 0, "tiro", 4);
		man.getApuestas().add(ap1);
		man.pagarApuestas(TipoJugada.feliz, new ResultadoCraps(4, 4));
	}

}
