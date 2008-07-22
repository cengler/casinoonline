package traga;

import java.util.List;

import casino.IJugador;
import casino.IMesa;

public class MesaTraga implements IMesa {

	private boolean abierta;
	private int cantApMax;
	private int id;
	private IJugador jugador;

	public MesaTraga(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param cantFichas
	 */
	public void calcularMontoAApostar(int cantFichas){

	}

	/**
	 * 
	 * @param jugador
	 * @param monto
	 * @param fichas
	 */
	public void crearApuesta(IJugador jugador, int monto, int fichas){

	}

	/**
	 * 
	 * @param jugador
	 */
	public void estaEnMesa(IJugador jugador){

	}

	/**
	 * 
	 * @param fichas
	 */
	public void getValorApuesta(int fichas){

	}

	/**
	 * 
	 * @param 8
	 * @param 25
	 * @param juan
	 */
	public MesaTraga(int a, int b, IJugador juan){

	}

	public int newIdMesa(){
		return 0;
	}

	/**
	 * 
	 * @param jugador
	 */
	public boolean estaJugando(IJugador jugador){
		return false;
	}

	public boolean getAbierta() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<IJugador> getJugadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAbierta(boolean abierta) {
		// TODO Auto-generated method stub
		
	}

	public boolean isAbierta() {
		// TODO Auto-generated method stub
		return false;
	}

}