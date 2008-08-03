package observerCraps;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import craps.IFotografiable;
import craps.msg.MSGEstadoCraps;

/**
 * ObservadorCraps. Representa la asociacion de un jugador con una
 * mesa de craps para el envio de mensajes de notificacion.
 * 
 * @author Administrador
 *
 */
public class ObservadorCraps implements Observer {

	private static Logger logger = Logger.getLogger(ObservadorCraps.class);
	private Observable observable;
	private String idJugador;
	private String idTVirt;
	
	public ObservadorCraps(){}

	public void setMesa(Observable mesa){
		observable = mesa;
	}
	
	public Observable getMesa(){
		return observable;
	}
	
	public void update(Observable o, Object obj) 
	{
		if(obj instanceof IFotografiable)
		{
			MSGEstadoCraps mensaje = ((IFotografiable)obj).sacarFoto();
			mensaje.setUsuario(getIdJugador());
			mensaje.setVTerm(getIdTVirt());
			InterpretadorCrapsSalida.getInstance().interpretar(mensaje);
		}
		else
		{
			logger.debug("La notificacion so es de interes para: " + getClass().getName() + ".");
		}
	}

	public String getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(String idJugador) {
		this.idJugador = idJugador;
	}

	public String getIdTVirt() {
		return idTVirt;
	}

	public void setIdTVirt(String idTVirt) {
		this.idTVirt = idTVirt;
	}
	
	

}