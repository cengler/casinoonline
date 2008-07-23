package casino;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import casino.msg.MSGEntradaCasino;
import casino.msg.MSGSalidaCasino;

public class ManejadorJugador implements IServiciosJugador {

	private static ManejadorJugador instance;
	private List<IInvitado> invitados;
	private Set<IJugador> jugadores = new HashSet<IJugador>();
	private List<IManejadorMesa> manejadores;

	private ManejadorJugador(){}
	
	public static ManejadorJugador getInstance()
	{
		if(instance == null)
			instance = new ManejadorJugador();
		return instance;
	}

	public MSGEntradaCasino entrarCasino(MSGEntradaCasino mensaje){
		return null;
	}

	public MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje){
		return null;
	}
	
	public void acreditar(IJugador jugador, int b){}

	public void AcreditarSaldo(Jugador jugador, int a, int b){}

	public void debitarMonto(Jugador jugador, int a, int b){	}

	public void estaJugando(IJugador jugador){}

	public ICliente getCliente(int idVitrual, String nombre){
		return null;
	}

	public boolean getJugador(String jugador){
		return false;
	}

	public void getJugadorLoggeado(Jugador jugador, int a, int b){
	}

	public boolean montoValidoPara(Jugador jugador){
		return false;
	}

	
	
	public List<IInvitado> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<IInvitado> invitados) {
		this.invitados = invitados;
	}

	public Set<IJugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<IJugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<IManejadorMesa> getManejadores() {
		return manejadores;
	}

	public void setManejadores(List<IManejadorMesa> manejadores) {
		this.manejadores = manejadores;
	}
}