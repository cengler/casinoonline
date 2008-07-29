package craps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import casino.IJugador;
import casino.TipoJugada;

/**
 * PagadorDeApuestas de una mesa en particular.
 * 
 * @author Grupo2
 *
 */
public class ManejadorDeApuestas {

	private List<ApuestaCraps> apuestas;
	//private static int porcentajeTP;
	
	
	
	public List<ApuestaCraps> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<ApuestaCraps> apuestas) {
		this.apuestas = apuestas;
	}

	public ManejadorDeApuestas(){}

	public void pagarApuestas(TipoJugada jugada, ResultadoCraps resultado)
	{
		int gananciaTotal = 0;
		Map<IJugador, Integer> ganancias = new HashMap<IJugador, Integer>();
		
		for (ApuestaCraps apuesta : apuestas)
		{
			if( apuesta.terminaApuesta(resultado) )
			{
				apuesta.setActiva(false);
				int ganancia = apuesta.obtenerGanancia(resultado);
				apuesta.setGanancia(ganancia);
				
				if( ganancias.containsKey(apuesta.getApostador()) )
				{
					ganancias.put(apuesta.getApostador(), ganancias.get(apuesta.getApostador()) + ganancia );
				}
				else
				{
					ganancias.put(apuesta.getApostador(), ganancia);
				}
				gananciaTotal += ganancia;
			}
		}
		
		if(jugada.equals(TipoJugada.feliz))
		{
			//TODO
		}
		
		if(jugada.equals(TipoJugada.todosponen))
		{
			for (IJugador j : ganancias.keySet() )
			{
				acreditar(j, quitarPorcentajeTP(ganancias.get(j)));
			}
		}
		
		if(jugada.equals(TipoJugada.normal))
		{
			for (IJugador j : ganancias.keySet() )
			{
				acreditar(j, ganancias.get(j));
			}
		}
	}

	private Integer quitarPorcentajeTP(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}

	private void acreditar(IJugador j, Integer integer) {
		// TODO Auto-generated method stub
		
	}

	/*public void correpondePagar(int a, <int, int> b){}
	
	public void gananciaTodosPonen(int a, int b){}

	public void obtenerGananciaAp(String a, <int, int> b, int c){}

	public void obtenerGananciaFeliz(int a, int b){}

	public void obtenerPorcentajeFeliz(int b, int c, int a){}

	public void pagarApuestas(TipoJugador jugador, <int, int> res, int int){}

	public void sumarATotal(int a){}
	
	public void pagarApuestas() {}*/
	
	public void crearNuevaApuesta(IJugador jug, int puntaje, String tipoAp, int valor){
		
		ApuestaCraps apc = new ApuestaCraps( jug,  puntaje, tipoAp, valor);
		this.getApuestas().add(apc);
	}
}
