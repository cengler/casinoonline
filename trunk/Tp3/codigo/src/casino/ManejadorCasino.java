package casino;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGsetModoDirigido;
import casino.msg.estadoCasino.MSGEstadoCasino;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ManejadorCasino implements IServiciosCasino {

	private static IServiciosCasino instance;
	private static Logger logger = Logger.getLogger(ManejadorCasino.class);
	private XStream xstream;
	private static String LISTA_JUG = "D:\\casino\\codigo\\xml\\abrir.xml" ;
	private List<ManejadorMesa> manejadores; 

	private ManejadorCasino()
	{
		manejadores = new ArrayList<ManejadorMesa>();
		
		xstream = new XStream(new DomDriver()); 
		xstream.alias("jugador", LSTJugador.class);
		xstream.alias("jugadores", ArrayList.class);
		xstream.aliasAttribute(LSTJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(LSTJugador.class, "saldo", "saldo");
		xstream.aliasAttribute(LSTJugador.class, "vip", "vip");
	}
	
	public static IServiciosCasino getInstance(){
		if(instance == null)
			instance = new ManejadorCasino();
		return instance;
	}
	

	public MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje)
	{
		Casino casino = Casino.getInstance();
		
		for (ManejadorMesa m : getManejadores())
		{
			//m
		}
		
		
		return null;
	}

	public MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje){
		return null;
	}

	public void resetModoDirigido(MSGsetModoDirigido unMSG){

	}

	public void setearModoDirigido(MSGResetModoDirigido unMSG){

	}

	public MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje) {
		
		Casino casino = Casino.getInstance();
		
		if(casino.isAbierto())
		{
			mensaje.setAceptado(false);
			mensaje.setDescripcion("Se deniega la reapertura del casino");
			
			logger.info("Se deniega la reapertura del casino");
		}
		else
		{
			cargarListaJugadores();
			mensaje.setAceptado(true);
			mensaje.setDescripcion("Se abre el casino correctamente");
			
			logger.info("Se abre el casino correctamente");
		}
		
		return mensaje;
	}
	
	private void cargarListaJugadores()
	{
		logger.info("Cargando jugadores...");
		
		List<LSTJugador> jugadores = null;
		
		try
		{
			InputStream is = new FileInputStream(LISTA_JUG);
			jugadores = (List<LSTJugador>)xstream.fromXML(is);
			if(jugadores == null)
				throw new Exception("El parseo no se realizo correctamente");
		}
		catch(Exception e)
		{
			logger.fatal("No se pudo obtener la lista de jugadores ", e);
			System.exit(-1);
		}
		
		ManejadorJugador mj = ManejadorJugador.getInstance();
		
		for( LSTJugador j : jugadores)
		{
			Jugador jc = new Jugador();
			jc.setNombre(j.getNombre());
			jc.setSaldo(j.getSaldo());
			jc.setVip(j.isVip());
			mj.getJugadores().add(jc);
			logger.debug("Cargando jugador: " + j.getNombre() + " Saldo: " + j.getSaldo() + " Vip: " + j.isVip());
		}
	}
		
	private void guardarListaJugadores()
	{
		//FileOutputStream fos = new FileOutputStream(path);  
		//xstream.toXML(msg, fos);;
	}

	public List<ManejadorMesa> getManejadores() {
		return manejadores;
	}

	public void setManejadores(List<ManejadorMesa> manejadores) {
		this.manejadores = manejadores;
	}
	
	

	/*public void validarFichas(List<Ficha> fichas){

	}*/
	
	/*public int calcularMontoAApostar(list<int a , fIcha ficha> lista){
	return 0;
	}*/
}