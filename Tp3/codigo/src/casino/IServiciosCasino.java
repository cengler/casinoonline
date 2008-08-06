package casino;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;
import casino.msg.MSGEstadoCasino;
import casino.msg.MSGReporteEstadoActual;
import casino.msg.MSGReporteRankingJugadores;

/**
 * IServiciosCasino.
 * 
 * @author Grupo2
 *
 */
public interface IServiciosCasino {

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGAbrirCasino abrirCasino(MSGAbrirCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGCerrarCasino cerrarCasino(MSGCerrarCasino mensaje);

	/**
	 * 
	 * @param mensaje
	 * @return
	 */
	MSGEstadoCasino estadoCasino(MSGEstadoCasino mensaje);
	
	/**
	 * 
	 * 
	 * @param msg
	 * @return
	 */	
	MSGReporteRankingJugadores reporteRanking(MSGReporteRankingJugadores msg);
	
	/**
	 * 
	 * @param msg
	 * @return
	 */
	MSGReporteEstadoActual reporteEstadoActual(MSGReporteEstadoActual msg);
		
}