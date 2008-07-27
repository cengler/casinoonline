package casino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import casino.msg.MSGEntradaCasino;
import casino.msg.MSGSalidaCasino;

/**
 * ManejadorJugador.
 * 
 * @author Grupo2
 *
 */
public class ManejadorJugador implements IServiciosJugador {

	private Logger logger = Logger.getLogger(ManejadorJugador.class);
	private static ManejadorJugador instance;
	private Set<IInvitado> invitados;
	private Set<IJugador> jugadores = new HashSet<IJugador>();
	private List<ManejadorMesa> manejadores;

	/**
	 * Constructor.
	 */
	private ManejadorJugador()
	{
		manejadores = new ArrayList<ManejadorMesa>();
		jugadores = new HashSet<IJugador>();
		invitados = new HashSet<IInvitado>();
	}
	
	public static ManejadorJugador getInstance()
	{
		if(instance == null)
			instance = new ManejadorJugador();
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGEntradaCasino entrarCasino(MSGEntradaCasino mensaje){
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje){
		return null;
	}
	
	// GETERS Y SETERS
	
	public Set<IInvitado> getInvitados() {
		return invitados;
	}

	public void setInvitados(Set<IInvitado> invitados) {
		this.invitados = invitados;
	}

	public Set<IJugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<IJugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<ManejadorMesa> getManejadores() {
		if(manejadores.size() == 0)
			logger.warn("REVISAR CONFIGURACION... NO HAY MANEJADORES DE JUEGO");
		return manejadores;
	}

	public void setManejadores(List<ManejadorMesa> manejadores) {
		this.manejadores = manejadores;
	}
	
	// FUNCIONES VARIAS
	
	public IJugador getJugadorLoggeado(String nombreJugador, int idTerm)
	{
		for(IJugador jug : jugadores)
		{
			if( (jug.getNombre().equals(nombreJugador)) ) 
			{
				if( ((jug.getIdVirt() == idTerm) && (jug.isLogeado())) )
					return jug;
			}	
			else
				return null;
		}
		return null;
	}
	
	
	public void acreditar(IJugador jugador, int b){}

	public void AcreditarSaldo(Jugador jugador, int a, int b){}

	public void debitarMonto(Jugador jugador, int a, int b){	}

	public boolean estaJugando(IJugador jugador)
	{
		boolean estaJugando = false;
		
		for( ManejadorMesa manejador : getManejadores() )
		{
			estaJugando = estaJugando || manejador.estaJugando(jugador);
		}
		
		return estaJugando;
	}

	public ICliente getCliente(int idVitrual, String nombre){
		return null;
	}

	public boolean getJugador(String jugador){
		return false;
	}

	public boolean montoValidoPara(Jugador jugador){
		return false;
	}
	
	public ManejadorMesa getManejador(String name)
	{
		for (ManejadorMesa m : manejadores )
		{
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}

	
}
