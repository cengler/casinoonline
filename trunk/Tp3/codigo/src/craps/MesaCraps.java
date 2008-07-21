package craps;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import casino.IJugador;
import casino.IMesa;
import casino.PagadorDeApuestas;

public class MesaCraps extends Observable implements IMesa {

	private boolean abierta;
	private List<ApuestaCraps> apuestas;
	private int id;
	private List<IJugador> jugadores;
	private boolean puck;
	private int punto;
	private IJugador Tirador;
	public JugadaCraps m_JugadaCraps;
	public ApuestaCraps m_ApuestaCraps;
	public PagadorDeApuestas m_PagadorDeApuestas;

	public MesaCraps(){

	}
	
	public boolean isPuck() {
		return puck;
	}



	public IJugador getTirador() {
		return Tirador;
	}



	public void setApuestas(List<ApuestaCraps> apuestas) {
		this.apuestas = apuestas;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setJugadores(List<IJugador> jugadores) {
		this.jugadores = jugadores;
	}



	public void setPunto(int punto) {
		this.punto = punto;
	}



	/**
	 * 
	 * @param ap
	 */
	public void addApuesta(ApuestaCraps ap){

	}

	/**
	 * 
	 * @param jugador
	 */
	public void addJugador(IJugador jugador){

	}

	/**
	 * 
	 * @param listaFichayValor
	 */
	public void calcularMontoAApostar(List<Integer> listaFichayValor){

	}

	/*public void crearApuesta(int numAp, Tipo tipoAp, IJugador jugador, int monto){

	}*/

	/**
	 * 
	 * @param jugador
	 */
	public boolean estaEnMesa(IJugador jugador){
		return false;
	}

	public List<ApuestaCraps> getApuestas(){
		return null;
	}

	public int getId(){
		return 0;
	}

	public List<Observer> getObservadores(){
		return null;
	}

	public int getPunto(){
		return 0;
	}

	public boolean puckApagado(){
		return false;
	}

	/**
	 * 
	 * @param jugador
	 */
	public void quitarJugador(IJugador jugador){

	}

	/**
	 * 
	 * @param a
	 * @param dados
	 */
	public boolean salioSiete(int a, int dados){
		return false;
	}

	/**
	 * 
	 * @param puck
	 */
	public void setPuck(boolean puck){

	}

	/**
	 * 
	 * @param tirador
	 */
	public void setTirador(IJugador tirador){

	}

	/**
	 * 
	 * @param jugador
	 */
	public boolean validarTirador(IJugador jugador){
		return false;
	}

	public List<IJugador> getJugadores(){
		return null;
	}

	public boolean getAbierta(){
		return false;
	}

	/**
	 * 
	 * @param abierta
	 */
	public void setAbierta(boolean abierta){

	}

	/**
	 * 
	 * @param jugador
	 */
	public boolean estaJugando(IJugador jugador){
		return false;
	}

}