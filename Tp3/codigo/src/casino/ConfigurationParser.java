package casino;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
	private static String LISTA_JUG = "configuration/listaJugadores.xml" ;
	private static String GENERAL_CONFIG_PROPERTIES = "configuration/generalConfig.properties" ;
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
		Object lista = null;
		try 
		{
			InputStream is = new FileInputStream(LISTA_JUG);
			lista = xstream.fromXML(is);
			is.close();
		} 
		catch (IOException e) 
		{
			logger.error("No se pudo cagar correctamente la lista de jugadores de: " + LISTA_JUG);
			throw new CasinoException("No se pudo cagar correctamente la lista de jugadores", e);
		}
		List<LSTJugador> l = (List<LSTJugador>)lista;
		return l;
	}
		
	/**
	 * Persiste la lista de jugadores que es encuentran en el casino.
	 * Solo deberia llamarse mientras el casino esta cerrado.
	 * 
	 * @param lista lista de jugadores que es encuentran en el casino.
	 * @throws FileNotFoundException si no esta el archivo de configuracion: ListaDeJugadores
	 */
	public void guardarListaJugadores(List<LSTJugador> lista) throws CasinoException
	{
		try {
			xstream.toXML(lista, new FileOutputStream(LISTA_JUG));
		} catch (FileNotFoundException e) {
			logger.error("El archivo: " + LISTA_JUG + " no se encuentra.");
			throw new CasinoException(e);
		}
	}
	
	public Properties cargarGeneralidades() throws CasinoException 
	{
		Properties properties = new Properties();
		InputStream is = null;
		try {
			logger.debug("Va a leer las cargarGeneralidades del archivo " + GENERAL_CONFIG_PROPERTIES);
			is = new FileInputStream(GENERAL_CONFIG_PROPERTIES);
			if(is!=null)
				properties.load(is);
			else
			{
				logger.debug("Propiedades leidas: ");
				for(Object o : properties.keySet())
					logger.debug("\t" + o.toString() + " = " + properties.getProperty(o.toString()));
			}
		} 
		catch (Exception e)
		{
			logger.error("El archivo: " + LISTA_JUG + " no se encuentra.");
			throw new CasinoException(e);
		}
		finally
		{
			try {
				is.close();
			} catch (IOException e) {
				logger.debug("No se pude cerrar el archivo");
			}
		}
		return properties;
	}
	
}
