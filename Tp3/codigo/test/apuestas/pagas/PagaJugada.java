package apuestas.pagas;

import java.util.HashMap;
import java.util.Map;

import core.Tuple;

public class PagaJugada {

	// LINEA DE PASE --------------------------------------
	Map<Tuple<Integer, Boolean>, Paga> ldp = new HashMap<Tuple<Integer, Boolean>, Paga>();
	
	// BARRA NO PASE --------------------------------------
	Map<Tuple<Integer, Boolean>, Paga> bnp = new HashMap<Tuple<Integer, Boolean>, Paga>();
	
	// APUESTAS DE CAMPO
	Map<Integer, Paga> adc = new HashMap<Integer, Paga>();
	
	// APUESTAS DE SITIO
	
	
}
