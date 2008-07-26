package observerCraps;

import java.util.Observable;
import java.util.Observer;

/**
 * ObservadorCraps. Representa la asociacion de un jugador con una
 * mesa de craps para el envio de mensajes de notificacion.
 * 
 * @author Administrador
 *
 */
public class ObservadorCraps implements Observer {

	private Observable observable;
	private String idJugador;
	private int idTVirt;
	
	public ObservadorCraps(){}

	public void setMesa(Observable mesa){
		observable = mesa;
	}
	
	public Observable getMesa(){
		return observable;
	}
	
	public void update(Observable o, Object obj) {
		//TODO
	}

	public String getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(String idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdTVirt() {
		return idTVirt;
	}

	public void setIdTVirt(int idTVirt) {
		this.idTVirt = idTVirt;
	}
	
	

}