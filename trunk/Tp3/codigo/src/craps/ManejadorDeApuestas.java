package craps;

import java.util.List;

/**
 * PagadorDeApuestas de una mesa en particular.
 * 
 * @author Grupo2
 *
 */
public class ManejadorDeApuestas {

	private List<ApuestaCraps> apuestas;
	
	
	
	
	public List<ApuestaCraps> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<ApuestaCraps> apuestas) {
		this.apuestas = apuestas;
	}

	public ManejadorDeApuestas(MesaCraps mesa){}

	/*public void correpondePagar(int a, <int, int> b){}
	
	public void gananciaTodosPonen(int a, int b){}

	public void obtenerGananciaAp(String a, <int, int> b, int c){}

	public void obtenerGananciaFeliz(int a, int b){}

	public void obtenerPorcentajeFeliz(int b, int c, int a){}

	public void pagarApuestas(TipoJugador jugador, <int, int> res, int int){}

	public void sumarATotal(int a){}
	
	public void pagarApuestas() {}*/
}
