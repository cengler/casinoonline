package servicios;

import casino.Jugador;
import casino.ManejadorJugador;
import craps.ManejadorMesaCraps;
import craps.MesaCraps;
import craps.msg.MSGEntradaCraps;

public class TestServiciosCraps {

	
	public static void main(String[] args) {
		//entrarCraps1();
		entrarCraps2();
	}
	
	public static void entrarCraps1()
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
	
	public static void entrarCraps2()
	{
		MSGEntradaCraps mensaje = new MSGEntradaCraps();
		mensaje.setUsuario("pepe");
		mensaje.setVTerm(50);
		mensaje.setMesa(20);
		
		// agrego a pepe
		Jugador pepe = new Jugador();
		pepe.setNombre("pepe");
		pepe.setIdVirt(50);
		pepe.setLogeado(true);
		ManejadorJugador.getInstance().getJugadores().add(pepe);
		
		SrvCraps.entrarCraps(mensaje);
		
		MesaCraps mesa = new MesaCraps(20);
		ManejadorMesaCraps.getInstance().getMesas().add(mesa);
		
		SrvCraps.entrarCraps(mensaje);
		
	}
}
