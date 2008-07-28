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
	
	public MesaCraps(int id) {
		super();
		this.id = id;
		abierta = true;
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

	public int compareTo(IMesa mesa) {
		return (new Integer(this.id)).compareTo(new Integer(mesa.getId()));
	}

	public boolean tieneApuestasActivas(IJugador jugador) {
		// TODO HACER
		return false;
	}

	public boolean saleCraps(ResultadoCraps resCraps){
		
		//TODO?
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == 2 || resul == 3 || resul ==6){
			res = true;
			
		}
		return res;
	}
	
	public boolean saleNatural(ResultadoCraps resCraps){
		
		//TODO?
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == 7 || resul == 11 ){
			res = true;
			
		}
		return res;
	}
	
	public void setPunto(ResultadoCraps resCraps){
		
		int resul = resCraps.getDado1() + resCraps.getDado2();
		this.punto = resul;
		
	}
	
	public boolean salioSiete(ResultadoCraps resCraps){
		
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == 7 ){
			res = true;
			
		}
		return res;
		
	}
	
	public boolean repitioPunto(ResultadoCraps resCraps, int pto){
		
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == pto ){
			res = true;
			
		}
		return res;
		
		
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