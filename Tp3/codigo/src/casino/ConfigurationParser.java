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
	private static String LISTA_JUG = "configuration/listaJugadores.xml";
	private static String LISTA_FICHAS = "configuration/fichasValidas.xml" ;
	private static String GENERAL_CONFIG_PROPERTIES = "configuration/generalConfig.properties";
	private static String SALDOS_FILE = "configuration/CFGSaldo.xml";
	private static Logger logger = Logger.getLogger(ConfigurationParser.class);
	private static ConfigurationParser instance; 
	
	/**
	 * Constructor.
	 * Registra los alias de la lista de jugadores.
	 */
	private ConfigurationParser()
	{
		xstream = new XStream(new DomDriver()); 
		xstream.alias("jugador", CFGJugador.class);
		xstream.alias("jugadores", ArrayList.class);
		xstream.alias("valorFicha", CFGValorFicha.class);
		xstream.alias("saldos", CFGSaldo.class);
		xstream.aliasAttribute(CFGJugador.class, "saldo", "saldo");
		xstream.aliasAttribute(CFGJugador.class, "vip", "vip");
		xstream.aliasAttribute(CFGJugador.class, "nombre", "nombre");
		xstream.aliasAttribute(CFGValorFicha.class, "ficha", "ficha");
		xstream.aliasAttribute(CFGValorFicha.class, "valor", "valor");
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
	public List<CFGJugador> cargarListaJugadores() throws CasinoException
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
		List<CFGJugador> l = (List<CFGJugador>)lista;
		return l;
	}
	
	public List<CFGValorFicha> cargarFichasValidas() throws CasinoException
	{
		Object lista = null;
		try 
		{
			InputStream is = new FileInputStream(LISTA_FICHAS);
			lista = xstream.fromXML(is);
			is.close();
		} 
		catch (IOException e) 
		{
			logger.error("No se pudo cagar correctamente la lista de fichas validas de: " + LISTA_FICHAS);
			throw new CasinoException("No se pudo cagar correctamente la lista de fichas validas", e);
		}
		List<CFGValorFicha> l = (List<CFGValorFicha>)lista;
		return l;
	}
		
	/**
	 * Persiste la lista de jugadores que es encuentran en el casino.
	 * Solo deberia llamarse mientras el casino esta cerrado.
	 * 
	 * @param lista lista de jugadores que es encuentran en el casino.
	 * @throws FileNotFoundException si no esta el archivo de configuracion: ListaDeJugadores
	 */
	public void guardarListaJugadores(List<CFGJugador> lista) throws CasinoException
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

	public void guardararSaldosCasino(CFGSaldo saldos) throws CasinoException
	{
		try {
			xstream.toXML(saldos, new FileOutputStream(SALDOS_FILE));
		} catch (FileNotFoundException e) {
			logger.error("El archivo: " + SALDOS_FILE + " no se encuentra.");
			throw new CasinoException(e);
		}
	}

	public CFGSaldo cargarSaldosCasino() throws CasinoException
	{
		Object saldos = null;
		try 
		{
			InputStream is = new FileInputStream(SALDOS_FILE);
			saldos = xstream.fromXML(is);
			is.close();
		} 
		catch (IOException e) 
		{
			logger.error("No se pudo cagar correctamente los saldos del casino de: " + SALDOS_FILE);
			throw new CasinoException("No se pudo cagar correctamente los saldos del casino", e);
		}
		CFGSaldo l = (CFGSaldo)saldos;
		return l;
	}
	
}
