package casino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;


import casino.msg.MSGCasino;
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
		
		if(!Casino.getInstance().isAbierto())
		{
			mensaje.setAceptado(MSGCasino.NO);
			mensaje.setDescripcion("El casino no esta abierto");
		}
		else
		{
			if( mensaje.getModoAcceso().equals(MSGEntradaCasino.MODO_JUGADOR) )
			{
				IJugador jugador = getJugador(mensaje.getUsuario());
				
				if(jugador == null)
				{
					mensaje.setAceptado(MSGCasino.NO);
					mensaje.setDescripcion("El jugador no esta registrado en el casino");
				}
				else if (jugador.isLogeado())
				{
					mensaje.setAceptado(MSGCasino.NO);
					mensaje.setDescripcion("El jugador ya esta logeado en el casino");
				}
				else
				{
					Jugador jugadorImpl = (Jugador)jugador;
					jugadorImpl.setLogeado(true);
					jugadorImpl.setModoObservador(false);
					jugadorImpl.setIdVirt(mensaje.getVTerm());
					
					mensaje.setAceptado(MSGCasino.SI);
					mensaje.setDescripcion("El jugador ha sido logeado");
					mensaje.setSaldo(jugadorImpl.getSaldo());
				}
			}
			else if( mensaje.getModoAcceso().equals(MSGEntradaCasino.MODO_OBSERVADOR) )
			{
				IJugador jugador = getJugador(mensaje.getUsuario());
				
				if(jugador == null)
				{
					// NO ES JUGADOR ES SOLO OBSERVADOR
					if (getInvitado(mensaje.getUsuario()) == null)
					{
						Invitado inv = new Invitado();
						inv.setIdVirt(mensaje.getVTerm());
						inv.setNombre(mensaje.getUsuario());
						invitados.add(inv);
					}
					else
					{
						// YA ESTA LOGEADO COMO OBSERVADOR
						mensaje.setAceptado(MSGCasino.NO);
						mensaje.setDescripcion("El cliente ya se encuentra logeado como invitado");
					}
				}
				else if (jugador.isLogeado())
				{
					mensaje.setAceptado(MSGCasino.NO);
					mensaje.setDescripcion("El jugador ya esta logeado en el casino");
				}
				else
				{
					// ES UN JUGADOR ENTRANDO CONO OBSERVADOR
					Jugador jugadorImpl = (Jugador)jugador;
					jugadorImpl.setLogeado(true);
					jugadorImpl.setModoObservador(true);
					jugadorImpl.setIdVirt(mensaje.getVTerm());
					
					mensaje.setAceptado(MSGCasino.SI);
					mensaje.setDescripcion("El jugador ha sido logeado como observaror");
					mensaje.setSaldo(jugadorImpl.getSaldo());
				}
			}
			else
			{
				mensaje.setAceptado(MSGCasino.NO);
				mensaje.setDescripcion("El modo de acceso no existe");
			}
		}
		
		logger.info("ENTRAR CASINO jug: " + mensaje.getUsuario() + 
				" idTV: " + mensaje.getVTerm() +
				" aceptado: " + mensaje.getAceptado() +
				" descripcion: " + mensaje.getDescripcion() );	
		return mensaje;
	}

	/**
	 * {@inheritDoc}
	 */
	public MSGSalidaCasino salirCasino(MSGSalidaCasino mensaje)
	{
		//para salir del casino, el mismo debe estar abierto.
		if(!Casino.getInstance().isAbierto())
		{
			mensaje.setAceptado(MSGCasino.NO);
			mensaje.setDescripcion("El casino no esta abierto");
		}
		else
		{
			IJugador jugador = getJugador(mensaje.getUsuario());
			IInvitado invitado = this.getInvitado(mensaje.getUsuario());
				
			if(jugador == null && invitado == null)
			{
				mensaje.setAceptado(MSGCasino.NO);
				mensaje.setDescripcion("El USUARIO no esta registrado en el casino");
			}
			else
			{ 
				//SI EL USUARIO Q SALE ES UN JUGADOR...
				if (jugador != null){
					if (!jugador.isLogeado())
					{
						mensaje.setAceptado(MSGCasino.NO);
						mensaje.setDescripcion("El jugador no esta logeado en el casino");
					}
					else
					{
						//ver si esta en algun juego
						boolean estaJugando = false;
						for (ManejadorMesa manMesa : this.manejadores)
						{
							estaJugando = manMesa.estaJugando(jugador);
						}
						if (estaJugando == true)
						{
							mensaje.setAceptado(MSGCasino.NO);
							mensaje.setDescripcion("No se puede desloggear al jugador, pues esta jugando " );
						}
						else
						{
							((Jugador)jugador).setLogeado(false);
							mensaje.setAceptado(MSGCasino.SI);
							mensaje.setDescripcion("El jugador ha salido del casino" );
						}
					}	
				}else{
					//EL QUE SALE ES UN INVITADO/OBSERVADOR
					//sacarlo de la lista de invitados.
					this.invitados.remove(invitado);
					mensaje.setAceptado(MSGCasino.SI);
					mensaje.setDescripcion("El invitado ha salido del casino");
				}		
			}
			
		logger.info("SALIR CASINO jug: " + mensaje.getUsuario() + 
				" idTV: " + mensaje.getVTerm() +
				" aceptado: " + mensaje.getAceptado() +
				" descripcion: " + mensaje.getDescripcion() );
		}
		return mensaje;
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
		//if(manejadores.size() == 0)
		//	logger.warn("REVISAR CONFIGURACION... NO HAY MANEJADORES DE JUEGO");
		return manejadores;
	}

	public void setManejadores(List<ManejadorMesa> manejadores) {
		this.manejadores = manejadores;
	}
	
	// FUNCIONES VARIAS
	
	public IJugador getJugadorLoggeado(String nombreJugador, String idTerm)
	{
		for(IJugador jug : jugadores)
		{
			if( (jug.getNombre().equals(nombreJugador)) ) 
			{
				
				if( ((jug.getIdVirt().equals(idTerm)) && (jug.isLogeado()) && !jug.isModoObservador()) )
					return jug;
			}	
		}
		return null;
	}

	public boolean estaJugando(IJugador jugador)
	{
		boolean estaJugando = false;
		
		for( ManejadorMesa manejador : getManejadores() )
		{
			estaJugando = estaJugando || manejador.estaJugando(jugador);
		}
		
		return estaJugando;
	}

	public IJugador getJugador(String jugador)
	{
		boolean res = false;
		IJugador jug = null;
		Iterator<IJugador> i = jugadores.iterator();
		while(i.hasNext() && !res)
		{
			jug = i.next();
			res = jug.getNombre().equals(jugador);
		}
		if(res)
			return jug;
		return null;
	}
	
	public IInvitado getInvitado(String invitado)
	{
		boolean res = false;
		IInvitado inv = null;
		Iterator<IInvitado> i = invitados.iterator();
		while(i.hasNext() && !res)
		{
			inv = i.next();
			if (inv.getNombre().equals(invitado)== true){
			//res = inv.getNombre().equals(invitado);
			  res = true;
			}
		}
		if (res == false){
				
			if (this.jugadores.contains(invitado)){
					
				for(IJugador j : jugadores){
						
					if (j.getNombre()== invitado && j.isLogeado()== false){
							
						res = true;
							
					}
						
				}
					
			}
				
		}
		
		if(res)
			return inv;
		return null;
	}

	public boolean montoValidoPara(IJugador jugador, int monto){
		
		return (jugador.getSaldo() >= monto);
				
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
	
	/**
	 * cargarListaJugadores.
	 * 
	 * @throws CasinoException 
	 * 
	 */
	public void cargarListaJugadores() throws CasinoException
	{
		logger.info("Cargando jugadores...");
		
		List<CFGJugador> jugadores;
		try {
			jugadores = ConfigurationParser.getInstance().cargarListaJugadores();
		} catch (CasinoException e) {
			logger.error(e.getMessage());
			throw new CasinoException(e);
		}
		
		ManejadorJugador mj = ManejadorJugador.getInstance();
		
		for( CFGJugador j : jugadores)
		{
			Jugador jc = new Jugador();
			jc.setNombre(j.getNombre());
			jc.setSaldo(j.getSaldo());
			jc.setSaldoInicial(j.getSaldo());
			jc.setVip(j.isVip());
			mj.getJugadores().add(jc);
			logger.debug("Cargando jugador: " + j.getNombre() + " Saldo: " + j.getSaldo() + " Vip: " + j.isVip());
		}
	}
	
	/**
	 * guardarListaJugadores.
	 * 
	 * @throws CasinoException 
	 *  
	 */
	public void guardarListaJugadores() throws CasinoException
	{
		ManejadorJugador manJug = ManejadorJugador.getInstance();
		
		List<CFGJugador> listajug = new ArrayList<CFGJugador>();
		
		for( IJugador j : manJug.getJugadores() )
		{
			CFGJugador jl = new CFGJugador();
			jl.setNombre(j.getNombre());
			jl.setSaldo(j.getSaldo());
			jl.setVip(j.isVip());
			logger.debug("Preparando para almacenamiento jugador: " + j.getNombre() + " Saldo: " + j.getSaldo() + " Vip: " + j.isVip());
			listajug.add(jl);
		}
		try {
			ConfigurationParser.getInstance().guardarListaJugadores(listajug);
		} catch (CasinoException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
}
