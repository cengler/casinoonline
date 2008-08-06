package casino.msg;
import java.util.List;

public class MSGReporteEstadoActual extends MSGAdministracion{
	
	
		private static String NAME = "ReporteEstadoActual";
		
		private List<MSGJugador> jugadores;
		private float saldoCasino;
		private MSGPozo pozo;

		public List<MSGJugador> getJugadores() {
			return jugadores;
		}

		public void setJugadores(List<MSGJugador> jugadores) {
			this.jugadores = jugadores;
		}

				
		public MSGPozo getPozo() {
			return pozo;
		}

		public void setPozo(MSGPozo pozo) {
			this.pozo = pozo;
		}

		public float getSaldoCasino() {
			return saldoCasino;
		}

		public void setSaldoCasino(float saldoCasino) {
			this.saldoCasino = saldoCasino;
		}

		public String getName() {
			return NAME;
		}
	}

