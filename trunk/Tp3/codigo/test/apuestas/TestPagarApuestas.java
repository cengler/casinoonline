package apuestas;

import org.apache.log4j.Logger;

import casino.Casino;
import casino.Jugador;
import casino.TipoJugada;

import craps.ApuestaCraps;
import craps.CrapsException;
import craps.ManejadorDeApuestas;
import craps.ResultadoCraps;
import craps.TipoApuestaCraps;

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
		man.pagarApuestas(TipoJugada.feliz, new ResultadoCraps(4, 4), true);
		
		Jugador pepe = new Jugador();
		ApuestaCraps ap1 = new ApuestaCraps(pepe, 8, TipoApuestaCraps.pase, 8);
		man.getApuestas().add(ap1);
		Casino.getInstance().setPozoFeliz(1100);
		man.pagarApuestas(TipoJugada.feliz, new ResultadoCraps(4, 4), true);
	}

}
