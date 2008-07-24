package servicios;

import casino.Jugador;
import casino.ManejadorJugador;
import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;

public class TestServicios {


	public static void main(String[] args) {
		
		abrirCasino();
		
		((Jugador)ManejadorJugador.getInstance().getJugadores().iterator().next()).setSaldo(123456789);
		
		cerrarCasino();
	}
	
	public static void abrirCasino()
	{
		SrvAdministracion.abrirCasino(new MSGAbrirCasino());
	}

	public static void cerrarCasino()
	{
		SrvAdministracion.cerrarCasino(new MSGCerrarCasino());
	}

}
