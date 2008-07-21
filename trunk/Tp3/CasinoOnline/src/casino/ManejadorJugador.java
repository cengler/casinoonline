package casino;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import parser.IMSG;
import parser.MSGEntradaCasino;
import parser.MSGEstadoCasino;
import parser.MSGSalidaCasino;

public class ManejadorJugador {

	private Logger logger = Logger.getLogger(ManejadorJugador.class);
	private static ManejadorJugador instance;
	private List<Invitado> invitados;
	private List<Jugador> jugadores;
	
	private ManejadorJugador()
	{}
	
	public static ManejadorJugador getInstance()
	{
		if(instance == null)
			instance = new ManejadorJugador();
		return instance;
	}
	
	private void acreditarSaldo(Jugador jug, int valor)
	{
		jug.setSaldo(jug.getSaldo() + valor);
	}
	
	private void debitarSaldo(Jugador jug, int valor)
	{
		// TODO ver verificacion vip
		jug.setSaldo(jug.getSaldo() - valor);
	}
	
	public MSGEntradaCasino entrarCasino(MSGEntradaCasino msg)
	{
		if ( msg.getModoAcceso().equals(MSGEntradaCasino.MODO_JUGADOR) )
		{
			Jugador j = getJugador(msg.getUsuario());
			if(j == null)
			{
				msg.setAceptado(MSGEntradaCasino.ACEPTADO_NO);
				msg.setDescripcion("El usuario no es usuario del casino");
			}
			else
			{
				if( j.isLogeado() )
				{
					msg.setAceptado(MSGEntradaCasino.ACEPTADO_NO);
					msg.setDescripcion("El usuario ya esta logeado en el casino");
				}
				else
				{
					j.setLogeado(true);
					j.setIdVirt(msg.getVTerm());
					msg.setAceptado(MSGEntradaCasino.ACEPTADO_SI);
					msg.setSaldo(j.getSaldo());
					msg.setDescripcion("El usuario se ha logeado correctamente");
				}	
			}
			
		}
		else if ( msg.getModoAcceso().equals(MSGEntradaCasino.MODO_OBSERVADOR) )
		{
			logger.debug("intentado entrar modo observador");
		}
		else
		{
			logger.error("intentado entrar modo DESCONOCIDO: " + msg.getModoAcceso());
		}
		return msg;
		
	}
	
	public MSGSalidaCasino salirCasino(MSGSalidaCasino msg)
	{
		// SALIR CASINO TODO
		return new MSGSalidaCasino();
	}

	public List<Invitado> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<Invitado> invitados) {
		this.invitados = invitados;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	private Jugador getJugador(String nombre)
	{
		for(Jugador j : jugadores)
		{
			if(j.getNombre().equals(nombre))
				return j;
		}
		return null;
	}
	
	public void levantarJugadores() throws FileNotFoundException
	{
		InputStream is = new FileInputStream("src/casino/jugadores.xml");
		
		XStream xstream = new XStream(new DomDriver()); 
		xstream.alias("jugador", Jugador.class);
		xstream.alias("jugadores", List.class);
		
		jugadores = (List<Jugador>)xstream.fromXML(is);	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ManejadorJugador.getInstance().levantarJugadores();
		
		//System.out.println(ManejadorJugador.getInstance().getJugadores());
	}
	
}
