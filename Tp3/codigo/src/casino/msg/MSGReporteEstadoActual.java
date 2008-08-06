package casino.msg;
import java.util.List;

public class MSGReporteEstadoActual extends MSGAdministracion{
	
	
		private static String NAME = "ReporteEstadoActual";
		
		private List<MSGJugador> jugadores;
		private float saldoCasino;
		private MSGPozo pozosCasino;

		public List<MSGJugador> getJugadores() {
			return jugadores;
		}

		public void setJugadores(List<MSGJugador> jugadores) {
			this.jugadores = jugadores;
		}
		
		public MSGPozo getPozosCasino() {
			return pozosCasino;
		}

		public void setPozosCasino(MSGPozo pozosCasino) {
			this.pozosCasino = pozosCasino;
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

