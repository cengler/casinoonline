package casino;

import java.util.Map;

public class SelectorTipoJugadaMD implements ISelectorTipoJugada {

	private static SelectorTipoJugadaMD instance;
	private Map<IMesa, TipoJugada> jugadasSeteadas;

	private SelectorTipoJugadaMD(){}

	public static SelectorTipoJugadaMD getInstance(){
		if(instance != null)
			instance = new SelectorTipoJugadaMD();
		return instance;
	}

	public TipoJugada getTipoJugada(IMesa mesa)
	{
		TipoJugada tj = jugadasSeteadas.get(mesa);
		jugadasSeteadas.remove(mesa);
		
		if(tj == null)
			tj = TipoJugada.jugadaNormal;
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
