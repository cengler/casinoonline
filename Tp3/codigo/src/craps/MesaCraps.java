package craps;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import casino.IJugador;
import casino.IMesa;

public class MesaCraps extends Observable implements IMesa {

	private boolean abierta;
	private List<ApuestaCraps> apuestas;
	private int id;
	private List<IJugador> jugadores;
	private boolean puck;
	private int punto;
	private IJugador tirador;
	
	public MesaCraps() {
		super();
		jugadores = new ArrayList<IJugador>();
	}

	public boolean isAbierta() {
		return abierta;
	}
	
	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}
	
	public List<ApuestaCraps> getApuestas() {
		return apuestas;
	}
	
	public void setApuestas(List<ApuestaCraps> apuestas) {
		this.apuestas = apuestas;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<IJugador> getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(List<IJugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public boolean isPuck() {
		return puck;
	}
	
	public void setPuck(boolean puck) {
		this.puck = puck;
	}
	
	public int getPunto() {
		return punto;
	}
	
	public void setPunto(int punto) {
		this.punto = punto;
	}
	
	public IJugador getTirador() {
		return tirador;
	}
	
	public void setTirador(IJugador tirador) {
		this.tirador = tirador;
	}

	public boolean estaJugando(IJugador jugador) {
		
		boolean esta = false;
		int i =  0;
		
		while(i < jugadores.size() && !esta)
		{
			esta = jugadores.get(i).equals(jugador);
			i++;
		}
		
		return esta;
	}

	/*public void setJugadores(List<IJugador> jugadores) {
	this.jugadores = jugadores;
	}
	
	
	public void calcularMontoAApostar(List<Integer> listaFichayValor){
	
	}
	
	public void crearApuesta(int numAp, Tipo tipoAp, IJugador jugador, int monto){
	
	}
	
	public boolean estaEnMesa(IJugador jugador){
		return false;
	}
	
	public void quitarJugador(IJugador jugador){
	
	}
	
	public boolean salioSiete(int a, int dados){
		return false;
	}
	
	public boolean validarTirador(IJugador jugador){
		return false;
	}*/

}