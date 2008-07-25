package casino;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * SelectorTipoJugadaMD.
 * 
 * @author Grupo2
 *
 */
public class SelectorTipoJugadaMD implements ISelectorTipoJugada {

	private static SelectorTipoJugadaMD instance;
	private Logger logger = Logger.getLogger(SelectorTipoJugadaMD.class); 
	private Map<IMesa, TipoJugada> jugadasSeteadas;

	/**
	 * Constructor.
	 */
	private SelectorTipoJugadaMD()
	{
		jugadasSeteadas = new TreeMap<IMesa, TipoJugada>();
	}

	/**
	 * Obtiene la unica instancia del Selector de tipo de jugada.
	 * 
	 * @return la unica instancia del Selector de tipo de jugada
	 */
	public static SelectorTipoJugadaMD getInstance(){
		if(instance == null)
			instance = new SelectorTipoJugadaMD();
		return instance;
	}

	/**
	 * Obtiene el tipo de jugada para la proxima jugada.
	 */
	public TipoJugada getTipoJugada(IMesa mesa)
	{
		TipoJugada tj = jugadasSeteadas.get(mesa);

		if(tj == null)
			tj = TipoJugada.jugadaNormal;
		else
			jugadasSeteadas.remove(mesa);
		
		logger.info("getTipoJugada para la mesa: " + mesa.getId() + " resulto: " + tj.name());
		
		return tj;
	}
	
	/**
	 * Agrega una jugada especial a la mesa ingresada como parametro.
	 * 
	 * @param mesa mesa a la cual asociarle el tipo de jugada
	 * @param tipo tipo de jugada a asociar con la mesa para la proxima jugada
	 */
	public void addJugadaSeteada(IMesa mesa, TipoJugada tipo)
	{
		jugadasSeteadas.put(mesa, tipo);
	}
}
