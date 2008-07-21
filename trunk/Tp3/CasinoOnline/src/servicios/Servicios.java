package servicios;

import casino.ManejadorJugador;
import parser.MSGEntradaCasino;
import parser.MSGEstadoCasino;
import parser.MSGSalidaCasino;

public class Servicios {
	
	MSGEntradaCasino entrarCasino(MSGEntradaCasino msg)
	{
		return ManejadorJugador.getInstance().entrarCasino(msg);
	}
	
	MSGSalidaCasino salirCasino(MSGSalidaCasino msg)
	{
		return ManejadorJugador.getInstance().salirCasino(msg);
	}
	
	MSGEstadoCasino estadoCasino(MSGEstadoCasino msg)
	{
		return new MSGEstadoCasino();
	}
}
