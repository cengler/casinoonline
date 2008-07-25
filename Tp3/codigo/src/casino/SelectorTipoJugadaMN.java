package casino;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * SelectorTipoJugadaMN.
 * 
 * @author Grupo2
 *
 */
public class SelectorTipoJugadaMN implements ISelectorTipoJugada {

	private static SelectorTipoJugadaMN instance;
	private Logger logger = Logger.getLogger(SelectorTipoJugadaMN.class);

	/**
	 * Constructor.
	 */
	private SelectorTipoJugadaMN(){
	}

	/**
	 * Obtiene la unica instancia del Selector de tipo de jugada.
	 * 
	 * @return la unica instancia del Selector de tipo de jugada
	 */
	public static SelectorTipoJugadaMN getInstance()
	{
		if(instance == null)
			instance = new SelectorTipoJugadaMN();
		return instance;
	}

	/**
	 * Obtiene el tipo de jugada para la proxima jugada.
	 */
	public TipoJugada getTipoJugada(IMesa mesa) {
		
		Random generator = new Random();
		int rnd = generator.nextInt(TipoJugada.values().length);
        
		logger.info("getTipoJugada para la mesa: " + mesa.getId() + " resulto: " + TipoJugada.values()[rnd].name());
		
		return TipoJugada.values()[rnd];
        
        
	}
}
