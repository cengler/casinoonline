package craps;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import casino.IJugador;
import casino.IMesa;
import craps.msg.MSGEstadoCraps;
import craps.msg.MSGJugadorCraps;
import craps.msg.MSGProxTiro;

public class MesaCraps extends Observable implements IMesa {


	public static String PUCK_APAGADO = "Si";
	public static String PUCK_PRENDIDO = "No";
		
	private boolean abierta;
	private int id;
	private List<IJugador> jugadores;
	private boolean puck;
	private int punto;
	private IJugador tirador;
	private IJugador tiradorAnterior; //TODO
	private int ultimoResultado; 
	private ManejadorDeApuestas pagador;
	private static Logger logger = Logger.getLogger(MesaCraps.class);
	
	public MesaCraps(int id)
	{
		this.id = id;
		abierta = true;
		jugadores = new ArrayList<IJugador>();
		pagador = new ManejadorDeApuestas();
		logger.debug("Creando mesa de craps: " + id);
	}

	public boolean isAbierta() {
		return abierta;
	}
	
	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
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
		// TODOMERY revisar
		
		ManejadorDeApuestas manAp = this.getPagador();
		//obtengo las apuestas de la mesa.
		List<ApuestaCraps> apuestas = manAp.getApuestas();
		//recorro las apuestas para ver si "jugador" tiene apuestas activas en la mesa
		int i = 0;
		boolean res = false;
		while (i < apuestas.size() && res == false){
			
			IJugador apostador = apuestas.get(i).getApostador();
			boolean activa = apuestas.get(i).isActiva();
			
			if(apostador == jugador || activa == true){
				
				res = true;
			}else{
				
				i++;
				
			}
			
			return res;
		}
		
	
		return false;
	}

	public boolean saleCraps(ResultadoCraps resCraps)
	{
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == 2 || resul == 3 || resul ==12){
			res = true;
		}
		return res;
	}
	
	public boolean saleNatural(ResultadoCraps resCraps)
	{
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == 7 || resul == 11 ){
			res = true;	
		}
		return res;
	}
	
	public void setPunto(ResultadoCraps resCraps)
	{
		int resul = resCraps.getDado1() + resCraps.getDado2();
		this.punto = resul;
	}
	
	public boolean salioSiete(ResultadoCraps resCraps)
	{
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == 7 ){
			res = true;
		}
		return res;
	}
	
	public boolean repitioPunto(ResultadoCraps resCraps, int pto)
	{
		boolean res = false;
		int resul = resCraps.getDado1() + resCraps.getDado2();
		if (resul == pto )
		{
			res = true;
		}
		return res;
	}

	public ManejadorDeApuestas getPagador() {
		return pagador;
	}

	public IJugador getTiradorAnterior() {
		return tiradorAnterior;
	}

	public void setTiradorAnterior(IJugador tiradorAnterior) {
		this.tiradorAnterior = tiradorAnterior;
	}

	public int getUltimoResultado() {
		return ultimoResultado;
	}

	public void setUltimoResultado(int ultimoResultado) {
		this.ultimoResultado = ultimoResultado;
	}
	
	//este metodo lo va a llamar un jugador desde una mesa.
	public MSGEstadoCraps sacarFoto(){
		
		MSGEstadoCraps msgEstCraps = new MSGEstadoCraps();  
		List<MSGJugadorCraps> lsJugC = new ArrayList<MSGJugadorCraps>();
		//seteo los jugadores de la mesa
		for (IJugador j : this.jugadores){
			
			MSGJugadorCraps msgJug = new MSGJugadorCraps(); 
				msgJug.setJugador(j.getNombre());
			lsJugC.add(msgJug);
		}
		msgEstCraps.setJugadores(lsJugC);
		//seteo proximo  tiro (MSGProxTiro)
		MSGProxTiro proxTiro = new MSGProxTiro();
		
			proxTiro.setTirador(this.getTirador().getNombre());
			if (this.isPuck()== true){ //puck prendido
				proxTiro.setTiroSalida(PUCK_PRENDIDO);
				
			}else{proxTiro.setTiroSalida(PUCK_APAGADO);}
		//private String tirador;
		//private String tiroSalida;
		//private int punto;
		
		//seteo tirador
		// seteo si es tiro de salida
		// seteo si es punto
		
		//seteo ultimo tiro (MSGUltimoTiro)
			//tirador
			//resultado
			//premios (ver como es)
		
		//seteo apuestas vigentes (MSGApuestasVigentes)
		
		return msgEstCraps;
	}
	
}