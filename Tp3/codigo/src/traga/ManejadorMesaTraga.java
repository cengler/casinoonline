package traga;

import java.util.ArrayList;
import java.util.List;

import traga.msg.MSGApuestaTraga;
import traga.msg.MSGEntradaTraga;
import traga.msg.MSGSalidaTraga;
import traga.msg.MSGTiroTraga;

import casino.IManejadorMesa;
import casino.IMesa;

public class ManejadorMesaTraga implements IManejadorMesa {

	private static ManejadorMesaTraga instance;
	private List<MesaTraga> mesas = new ArrayList<MesaTraga>();
	private int premioProgresivo;

	
	// ------------------------------------------------- //
	// CONSTRUCTORES
	// ------------------------------------------------- //
	
	private ManejadorMesaTraga(){

	}

	public static ManejadorMesaTraga getInstance()
	{
		if(instance == null)
			instance = new ManejadorMesaTraga();
		return instance;
	}
	
	// ------------------------------------------------- //
	// METODOS DE MENSAJERIA
	// ------------------------------------------------- //
	
	
	public MSGApuestaTraga apostarTraga(MSGApuestaTraga mensaje){
		return null; // TODO
	}

	public MSGEntradaTraga entrarTraga(MSGEntradaTraga mensaje){
		return null; //TODO
	}
	
	public MSGSalidaTraga salirTraga(MSGSalidaTraga mensaje){
		return null; //TODO
	}
	
	public MSGTiroTraga tirarTraga(MSGTiroTraga unMSGtiroTraga){
		return null; //TODO
	}
	
	
	// ------------------------------------------------- //
	// METODOS DE PRIVADOS
	// ------------------------------------------------- //
	
	private void addMesa(MesaTraga unaMesa){
		mesas.add(unaMesa);
	}	
	
	public int newIdMesa(){
		return 0;
	}
	
	public boolean validarCantFicha(int a){
		return false;
	}

	public boolean verificarMesasCerradas(){
		return false;
	}

	/*public List<MesaTraga> getMesas(){
		return null;
	}*/

	/*public void getPremioJugada(<simbolo, simbolo, simbolo> res){

	}*/
	
	
	// ------------------------------------------------- //
	// GETERS Y SETERS
	// ------------------------------------------------- //
	
	public List<IMesa> getMesas() {
		return new ArrayList<IMesa>(mesas);
	}

	public void setMesas(List<MesaTraga> mesas) {
		this.mesas = mesas;
	}

	public int getPremioProgresivo() {
		return premioProgresivo;
	}

	public void setPremioProgresivo(int premioProgresivo) {
		this.premioProgresivo = premioProgresivo;
	}
	
	
	



}