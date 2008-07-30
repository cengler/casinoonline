package craps;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import casino.Casino;
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
	
	private Logger logger = Logger.getLogger(ManejadorDeApuestas.class);
	
	public List<ApuestaCraps> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<ApuestaCraps> apuestas) {
		this.apuestas = apuestas;
	}

	public ManejadorDeApuestas()
	{
		apuestas = new ArrayList<ApuestaCraps>();
	}

	public void pagarApuestas(TipoJugada jugada, ResultadoCraps resultado)
	{
		logger.debug("pagarApuestas( TJ: " +jugada + " RC: " +resultado+")" );
		
		int gananciaTotal = 0;
		Casino casino = Casino.getInstance();
		
		
		logger.debug("Obteniendo ganancia bruta de las apuestas..." );
		
		// OBTENGO LA GANANCIA BRUTA DE CADA APUESTA
		for (ApuestaCraps apuesta : apuestas)
		{
			if( apuesta.terminaApuesta(resultado) )
			{
				logger.info("Termina la apuesta " + apuesta);
				int ganancia = apuesta.obtenerGanancia(resultado);
				apuesta.setGanancia(ganancia);
				gananciaTotal += ganancia;
			}
		}
		logger.debug("ganancia bruta de las apuestas obtenido" );
		
		
		// AJUSTO LA LA GANANCIA SEGUN LAS MODIFICACIONES DE CADA TIPO DE JUGADA
		if(jugada.equals(TipoJugada.todosponen)) // TODOSPONEN
		{
			
			for (ApuestaCraps apuesta : apuestas)
			{
				if( apuesta.terminaApuesta(resultado) )
				{
					apuesta.setActiva(false);
					
					// ACTUALIZA LA GANANCIA DE LA APUESTA
					// INCREMENTA POZO FELIZ
					// DECREMENTA AL CASINO EL MONTO PARA DICHO POZO
					apuesta.setGanancia(pagarTodosPonen(apuesta.getGanancia()));
					
					// PAGA AL JUGADOR
					acreditarGanancia(apuesta.getApostador(), apuesta.getGanancia());
					// DESCUENTA AL CASINO EL PAGO
					casino.setSaldo(casino.getSaldo() - apuesta.getGanancia());
				}
			}
		}
		else if (jugada.equals(TipoJugada.feliz))
		{
			int pozoFeliz = casino.getPozoFeliz();
			
			for (ApuestaCraps apuesta : apuestas)
			{
				if( apuesta.terminaApuesta(resultado) )
				{
					apuesta.setActiva(false);
					
					// DESCONTAR AL CASINO LO QUE DEBERA PAGAR AL JUGADOR
					int ganancaBruta = apuesta.getGanancia();
					casino.setSaldo(casino.getSaldo() - ganancaBruta);
					
					// ACTUALIZA LA GANANCIA DE LA APUESTA
					int porcentajePozoFeliz = (ganancaBruta / gananciaTotal) * pozoFeliz;
					apuesta.setGanancia(ganancaBruta + porcentajePozoFeliz);
					
					// PAGA AL JUGADOR
					acreditarGanancia(apuesta.getApostador(), apuesta.getGanancia());			
				}
			}
			// SE RESETEA EL POZO FELIZ
			casino.setPozoFeliz(0);
		}
		else
		{
			for (ApuestaCraps apuesta : apuestas)
			{
				if( apuesta.terminaApuesta(resultado) )
				{
					apuesta.setActiva(false);
					
					// PAGA AL JUGADOR
					acreditarGanancia(apuesta.getApostador(), apuesta.getGanancia());
					// DESCUENTA AL CASINO EL PAGO
					casino.setSaldo(casino.getSaldo() - apuesta.getGanancia());
				}
			}
		}
	}

	/**
	 * acreditarGanancia acredita al jugador y descuenta al casino
	 * en monto ingresado como parametro.
	 * 
	 * @param apostador jugador que realizó la apuesta
	 * @param ganancia monto a acreditar
	 */
	private void acreditarGanancia(IJugador apostador, int ganancia) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * pagarTodosPonen incrementa el pozo feliz segun el porcentaje
	 * seteado (sacandolo del saldo del casino) 
	 * y devuelve el valor de la ganancia decrementado con el impuesto.
	 * 
	 * @param ganancia ganancia bruta de la apuesta
	 * @return el valor de la ganancia decrementado con el impuesto.
	 */
	private int pagarTodosPonen(int ganancia) {
		// TODO Auto-generated method stub
		return 0;
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
