package servicios;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGSetJugada;
import casino.msg.TipoJugada;

public class TestServicios {


	public static void main(String[] args) {
		
		/*abrirCasino();
		
		((Jugador)ManejadorJugador.getInstance().getJugadores().iterator().next()).setSaldo(123456789);
		
		cerrarCasino();*/
		
		setearJugada();
	}
	
	public static void abrirCasino()
	{
		SrvAdministracion.abrirCasino(new MSGAbrirCasino());
	}

	public static void cerrarCasino()
	{
		SrvAdministracion.cerrarCasino(new MSGCerrarCasino());
	}
	
	public static void setearJugada()
	{
		MSGSetJugada m = new MSGSetJugada();
		m.setJuego("craps");
		m.setMesa(10);
		m.setTipo(TipoJugada.feliz);
		
		SrvAdministracion.setearJugada(m);
	}
}
