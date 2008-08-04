package casino.msg;

import java.util.List;

public class MSGReporteRankingJugadores extends MSGAdministracion 
{	
	private static String NAME = "ReporteRankingJugadores";
	
	private List<MSGJugador> jugadores;

	public List<MSGJugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<MSGJugador> jugadores) {
		this.jugadores = jugadores;
	}

	public String getName() {
		return NAME;
	}
}
