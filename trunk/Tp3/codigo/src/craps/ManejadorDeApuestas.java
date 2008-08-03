package craps;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import craps.core.TipoApuestaCraps;

import au.com.bytecode.opencsv.CSVReader;

import casino.Casino;
import casino.IJugador;
import casino.core.TipoJugada;

/**
 * PagadorDeApuestas de una mesa en particular.
 * 
 * @author Grupo2
 *
 */
public class ManejadorDeApuestas {

	private List<ApuestaCraps> apuestas;
	private Logger logger = Logger.getLogger(ManejadorDeApuestas.class);
	
	private static String RES_POS_FILE = "configuration/pagos.csv";
	private static String MOD_FILE = "configuration/modificaciones.csv";
	private static boolean loadConf = false;
	private static Map<ResultadoApuestaCraps, PagoApuesta> pagos;
	private static Map<ModificacionApuestaCraps, Integer> modificaciones;
	
	/**
	 * Constructor.
	 */
	public ManejadorDeApuestas()
	{	
		apuestas = new ArrayList<ApuestaCraps>();
		if(!loadConf)
			loadConfiguration();
	}
	
	/**
	 * Carga la configuracion de los resultados y modificaciones a apuestas.
	 */
	private void loadConfiguration()
	{
		logger.info("Cargando informacion de modificaciones y pagos de apuestas...");
		try {
			pagos = new HashMap<ResultadoApuestaCraps, PagoApuesta>();
			modificaciones = new HashMap<ModificacionApuestaCraps, Integer>();
			loadResultadosPosibles();
			loadModificaciones();
		} catch (CrapsException e) {
			logger.fatal("No se pudo cargar el manejador de apuestas," +
				" problemas en la configuracion de modificaciones y pagos de apuestas", e);
		}
		
	}

	/**
	 * Carga la configuracion de los resultados posibles.
	 * 
	 * @throws CrapsException en caso de no encontrar el archivo de configuracion
	 */
	public void loadResultadosPosibles() throws CrapsException
	{
		try {
			CSVReader reader = new CSVReader(new FileReader(new File(RES_POS_FILE)));
		    String [] line;
		    while ((line = reader.readNext()) != null)
		    {
		    	ResultadoApuestaCraps res = new ResultadoApuestaCraps(line[0].trim(), line[1].trim(), 
		    			Integer.parseInt(line[2].trim()), Integer.parseInt(line[3].trim()));
		    	
		    	PagoApuesta pago = new PagoApuesta(Integer.parseInt(line[4].trim()), Integer.parseInt(line[4].trim()));
		    	
		    	pagos.put(res, pago);
		    }
		} catch (Exception e) {
			logger.fatal("No se han podido cargar los resultados posibles para las apuestas de craps: ", e);
			throw new CrapsException(e);
		}
		logger.debug("PAGOS A APUESTAS CARGADAS: " + pagos);
	}
	
	/**
	 * Carga la configuracion de las modificaciones a apuestas.
	 * 
	 * @throws CrapsException en caso de no encontrar el archivo de configuracion
	 */
	public void loadModificaciones() throws CrapsException
	{
		try {
			CSVReader reader = new CSVReader(new FileReader(new File(MOD_FILE)));
		    String [] line;
		    while ((line = reader.readNext()) != null)
		    {
		    	ModificacionApuestaCraps res = new ModificacionApuestaCraps(line[0].trim(), line[1].trim(), Integer.parseInt(line[2].trim()) );
		    	modificaciones.put(res, Integer.parseInt(line[3].trim()));
		    }
		} catch (Exception e) {
			logger.fatal("No se han podido cargar las modificaciones para las apuestas de craps: ", e);
			throw new CrapsException(e);
		}
		
		logger.debug("MOD A APUESTAS CARGADAS: " + modificaciones);
	}
	
	/**
	 * Obtiene la lista de apuestas.
	 * 
	 * @return la lista de apuestas
	 */
	public List<ApuestaCraps> getApuestas() {
		return apuestas;
	}

	/**
	 * Setea la lista de apuestas.
	 * 
	 * @param apuestas la lista de apuestas a setear
	 */
	public void setApuestas(List<ApuestaCraps> apuestas) {
		this.apuestas = apuestas;
	}

	/**
	 * Paga tadas las apuestas que se puedan solucionar con el tiro realizado.
	 * 
	 * @param jugada tipo de jugada que se esta pagando
	 * @param resultado resultado que salieron en los dados
	 * @param puck estado del puck antes de computar el tiro
	 */
	public void pagarApuestas(TipoJugada jugada, ResultadoCraps resultado, boolean puck)
	{
		logger.debug("pagarApuestas( TJ: " +jugada + " RC: " +resultado+ " puck: " +puck+")" );
		
		int gananciaTotal = 0;
		Casino casino = Casino.getInstance();
		
		
		logger.debug("Obteniendo ganancia bruta de las apuestas..." );
		
		// OBTENGO LA GANANCIA BRUTA DE CADA APUESTA
		for (ApuestaCraps apuesta : apuestas)
		{
			if( correspondePagar(apuesta, resultado, puck) )
			{
				logger.info("Termina la apuesta " + apuesta);
				int ganancia = obtenerGanancia(apuesta, resultado, puck);
				apuesta.setGanancia(ganancia);
				gananciaTotal += ganancia;
			}
		}
		
		logger.debug("ajusto ganancia segun tipo de jugada y pago..." );
		// AJUSTO LA LA GANANCIA SEGUN LAS MODIFICACIONES DE CADA TIPO DE JUGADA
		if(jugada.equals(TipoJugada.todosponen)) // TOD OSPONEN
		{
			
			for (ApuestaCraps apuesta : apuestas)
			{
				if( correspondePagar(apuesta, resultado, puck) )
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
			// TODO VER VALIDACION POZO FELIZ
			
			for (ApuestaCraps apuesta : apuestas)
			{
				if( correspondePagar(apuesta, resultado, puck) )
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
				if( correspondePagar(apuesta, resultado, puck) )
				{
					apuesta.setActiva(false);
					
					// PAGA AL JUGADOR
					acreditarGanancia(apuesta.getApostador(), apuesta.getGanancia());
					// DESCUENTA AL CASINO EL PAGO
					casino.setSaldo(casino.getSaldo() - apuesta.getGanancia());
				}
			}
		}
		logger.debug("Fin de pagar apuestas. Se han pagado del saldo del casino: " + gananciaTotal + " pesos");
	}

	/**
	 * obtenerGanancia.
	 * PRECONDICION: la apuesta tiene garantizada una ganancia para el resultado y el estado del puck ingresados.
	 * VER: correspondePagar.
	 * 
	 * @param apuesta apuesta que intento pagar
	 * @param resultado resultado del ultimo tiro
	 * @param puck puck previo al seteo del ultimo tiro
	 * @return el monto a pagar a la apuesta
	 */
	private int obtenerGanancia(ApuestaCraps a, ResultadoCraps r, boolean puck)
	{
		String pck = Boolean.toString(puck);
		ResultadoApuestaCraps res = new ResultadoApuestaCraps( a.getTipo().name(), pck, r.getDado1()+r.getDado2(), a.getPuntaje());
		return getPago(pagos.get( res ), a.getValor());
	}
	
	/**
	 * El jugador Pepe apuesta una ficha de $ 2 y una de $ 5 en una apuesta 5:11. 
	 * El casino le debita $7 de su cuenta y registra la apuesta (con un valor total de $7)
	 * 
	 * Si la apuesta resulta ganadora, el casino acreditará en la cuenta del jugador 
	 * Pepe los $7 de la apuesta original más el pago calculado según la regla 5:11 
	 * ( $7 * 5 / 11 ).  O sea, el casino acredita $ 10,18 en la cuenta de Pepe. 
	 * @param pago
	 * @param valor
	 * @return
	 */
	private int getPago(PagoApuesta pago, int valor)
	{
		return valor + (valor * pago.getFichas() / pago.getPago()); 
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
	
	public void crearNuevaApuesta(IJugador jug, int puntaje, TipoApuestaCraps tipoAp, int valor){
		
		ApuestaCraps apc = new ApuestaCraps( jug,  puntaje, tipoAp, valor);
		this.getApuestas().add(apc);
	}
	
	public boolean correspondePagar(ApuestaCraps a, ResultadoCraps r, boolean puck)
	{
		String pck = Boolean.toString(puck);
		ResultadoApuestaCraps res = new ResultadoApuestaCraps( a.getTipo().name(), pck, r.getDado1()+r.getDado2(), a.getPuntaje());
		logger.debug("Corresponde pagar a: " + res + " --> "+ pagos.containsKey( res ));
		return pagos.containsKey( res );
    }
}
