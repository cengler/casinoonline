package casino;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import sun.util.logging.resources.logging;

public class SelectorTipoJugadaMD implements ISelectorTipoJugada {

	private static SelectorTipoJugadaMD instance;
	private Logger logger = Logger.getLogger(SelectorTipoJugadaMD.class); 
	private Map<IMesa, TipoJugada> jugadasSeteadas;

	private SelectorTipoJugadaMD()
	{
		jugadasSeteadas = new TreeMap<IMesa, TipoJugada>();
	}

	public static SelectorTipoJugadaMD getInstance(){
		if(instance == null)
			instance = new SelectorTipoJugadaMD();
		return instance;
	}

	
	public TipoJugada getTipoJugada(IMesa mesa)
	{
		logger.debug("getTipoJugada para mesa: " + mesa.getId());
		
		TipoJugada tj = jugadasSeteadas.get(mesa);

		logger.debug("mesa tiene una jugada seteada: " + jugadasSeteadas.containsKey(mesa));
		
		if(tj == null)
			tj = TipoJugada.jugadaNormal;
		else
			System.out.println();
			//jugadasSeteadas.remove(mesa);
		return tj;
	}
	
	public Map<IMesa, TipoJugada> getJugadasSeteadas() {
		return jugadasSeteadas;
	}

	public void setJugadasSeteadas(Map<IMesa, TipoJugada> jugadasSeteadas) {
		this.jugadasSeteadas = jugadasSeteadas;
	}

	public void addJugadaSeteada(IMesa mesa, TipoJugada tipo)
	{
		jugadasSeteadas.put(mesa, tipo);
	}
}
