package mensajes;

import core.FileMessage;
import core.IMessage;
import core.MensajeroException;
import craps.ManejadorMesaCraps;
import craps.MesaCraps;
import parser.ParserCasino;
import parser.ParserException;
import casino.Jugador;
import casino.ManejadorCasino;
import casino.ManejadorJugador;
import casino.msg.estadoCasino.MSGEstadoCasino;


public class TestEstadoCasino {

	public static void main(String[] args) throws MensajeroException, ParserException {
		
		ManejadorJugador.getInstance().getManejadores().add(ManejadorMesaCraps.getInstance());
		
		MSGEstadoCasino mensaje = new MSGEstadoCasino();
		mensaje.setUsuario("pepe");
		mensaje.setVTerm("50");
		
		Jugador jug = new Jugador();
		jug.setNombre("pepe");
		jug.setIdVirt("50");
		jug.setLogeado(true);
		ManejadorJugador.getInstance().getJugadores().add(jug);
		
		MesaCraps mesa = new MesaCraps(1);
		mesa.setAbierta(true);
		mesa.getJugadores().add(jug);
		mesa.setTirador(jug);
		ManejadorMesaCraps.getInstance().getMesas().add(mesa);
		
		ManejadorCasino.getInstance().estadoCasino(mensaje);
		
		
		IMessage msg = new FileMessage("D:/casino/test/estado.xml");
		
		ParserCasino.getInstance().renderizar(mensaje, msg);
		
		System.out.println("\n" + msg.getData());
	}
}
