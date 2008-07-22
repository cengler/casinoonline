package craps;

import java.util.ArrayList;
import java.util.List;

import craps.msg.MSGApuestaCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGEstadoCraps;
import craps.msg.MSGSalidaCraps;
import craps.msg.MSGTiroCraps;

import casino.IManejadorMesa;
import casino.IMesa;

public class ManejadorMesaCraps implements IManejadorMesa {

	private static ManejadorMesaCraps instance;
	private List<MesaCraps> mesas;

	private ManejadorMesaCraps(){

	}

	public void agregarObservador(String idJugador, String idTVirt, IMesa mesa){

	}

	public MSGApuestaCraps apostarCraps(MSGApuestaCraps mensaje){
		return null;
	}

	public MSGEntradaCraps entrarCraps(MSGEntradaCraps mensaje){
		return null;
	}

	public MSGEstadoCraps estadoCraps(IMesa mesa){
		return null;
	}

	public static ManejadorMesaCraps getInstance(){
		if(instance == null)
			instance = new ManejadorMesaCraps();
		return instance;
	}

	public List<MesaCraps> getMesasAbiertas(){
		return null;
	}

	public int newIdMesa(){
		return 0;
	}

	public void quitarObservador(String idJugador, IMesa mesa){

	}

	/*public void repitioPunto(int a, <int, int> b){

	}*/

	/**
	 * 
	 * @param dado
	 * @param dado2
	 */
	public boolean saleCraps(int dado, int dado2){
		return false;
	}

	/**
	 * 
	 * @param dado
	 * @param dado2
	 */
	public boolean saleNatural(int dado, int dado2){
		return false;
	}

	public MSGSalidaCraps salirCraps(MSGSalidaCraps mensaje){
		return null;
	}

	public void tirarCraps(MSGTiroCraps unMSG){

	}

	public boolean verificarMesasCerradas(){
		return false;
	}

	public List<IMesa> getMesas() {
		return new ArrayList<IMesa>(mesas);
	}

	/*public List<MesaCraps> getMesas(){
		return mesas;
	}*/

}