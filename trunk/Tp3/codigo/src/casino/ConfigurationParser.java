package casino;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Parser de configuracion del casino.
 * 
 * @author Grupo2
 *
 */
public class ConfigurationParser {

	private XStream xstream;
	private static String LISTA_JUG = "I:/- 21-07-08/TPPP/Tp3/codigo/xml/abrir.xml" ; 
	// TODO ruta relativa ^
	private static Logger logger = Logger.getLogger(ConfigurationParser.class);
	private static ConfigurationParser instance; 
	
	/**
	 * Constructor.
	 * Registra los alias de la lista de jugadores.
	 */
	private ConfigurationParser()
	{
		xstream = new XStream(new DomDriver()); 
		xstream.alias("jugador", LSTJugador.class);
		xstream.alias("jugadores", ArrayList.class);
		xstream.aliasAttribute(LSTJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(LSTJugador.class, "saldo", "saldo");
		xstream.aliasAttribute(LSTJugador.class, "vip", "vip");
	}
	
	public static ConfigurationParser getInstance()
	{
		if (instance == null)
			instance = new ConfigurationParser();
		return instance;
	}
	
	
	/**
	 * Carga la lista de los jugadores con su saldo y atributos.
	 * 
	 * @return lista de los jugadores con su saldo y atributos.
	 * @throws FileNotFoundException si no esta el archivo de configuracion: ListaDeJugadores
	 * @throws CasinoException 
	 */
	public List<LSTJugador> cargarListaJugadores() throws CasinoException
	{
		List<LSTJugador> lista = null;
		try 
		{
			InputStream is = new FileInputStream(LISTA_JUG);
			lista = (List<LSTJugador>)xstream.fromXML(is);
			is.close();
		} 
		catch (IOException e) 
		{
			logger.error("No se pudo cagar correctamente la lista de jugadores de: " + LISTA_JUG);
			throw new CasinoException("No se pudo cagar correctamente la lista de jugadores", e);
		}
		return lista;
	}
		
	/**
	 * Persiste la lista de jugadores que es encuentran en el casino.
	 * Solo deberia llamarse mientras el casino esta cerrado.
	 * 
	 * @param lista lista de jugadores que es encuentran en el casino.
	 * @throws FileNotFoundException si no esta el archivo de configuracion: ListaDeJugadores
	 */
	public void guardarListaJugadores(List<LSTJugador> lista) throws FileNotFoundException
	{
		xstream.toXML(lista, new FileOutputStream(LISTA_JUG));
	}
}
