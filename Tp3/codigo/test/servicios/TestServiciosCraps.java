package servicios;

import casino.Jugador;
import casino.ManejadorJugador;
import craps.msg.MSGEntradaCraps;

public class TestServiciosCraps {

	
	public static void main(String[] args) {
		entrarCraps();
	}
	
	public static void entrarCraps()
	{
		MSGEntradaCraps mensaje = new MSGEntradaCraps();
		mensaje.setUsuario("pepe");
		mensaje.setVTerm(50);
		
		
		SrvCraps.entrarCraps(mensaje);
		
		// agrego a pepe
		Jugador pepe = new Jugador();
		pepe.setNombre("pepe");
		ManejadorJugador.getInstance().getJugadores().add(pepe);
		
		SrvCraps.entrarCraps(mensaje);
		
		pepe.setIdVirt(50);
		
		SrvCraps.entrarCraps(mensaje);
		
		pepe.setLogeado(true);
		
		SrvCraps.entrarCraps(mensaje);
		SrvCraps.entrarCraps(mensaje);
	}
}
