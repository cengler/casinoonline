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
import craps.msg.MSGUltimoTiro;
import craps.msg.MSGApuesta;
import craps.msg.MSGApuestasVigentes;
import craps.msg.MSGOpcionApuesta;
import craps.msg.MSGPremio;
import craps.msg.MSGValorFicha;
 

public class MesaCraps extends Observable implements IMesa, IFotografiable {


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
		setChanged();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		setChanged();
	}
	
	public List<IJugador> getJugadores() {
		setChanged();
		return jugadores;
	}
	
	public void setJugadores(List<IJugador> jugadores) {
		setChanged();
		this.jugadores = jugadores;
	}
	
	public boolean isPuck() {
		return puck;
	}
	
	public void setPuck(boolean puck) {
		this.puck = puck;
		setChanged();
	}
	
	public int getPunto() {
		return punto;
	}
	
	public void setPunto(int punto) {
		this.punto = punto;
		setChanged();
	}
	
	public IJugador getTirador() {
		return tirador;
	}
	
	public void setTirador(IJugador tirador) {
		this.tirador = tirador;
		setChanged();
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
		setChanged();
		return pagador;
	}

	public IJugador getTiradorAnterior() {
		return tiradorAnterior;
	}

	public void setTiradorAnterior(IJugador tiradorAnterior) {
		this.tiradorAnterior = tiradorAnterior;
		setChanged();
	}

	public int getUltimoResultado() {
		return ultimoResultado;
	}

	public void setUltimoResultado(int ultimoResultado) {
		this.ultimoResultado = ultimoResultado;
		setChanged();
	}
	

//	este metodo lo va a llamar un jugador desde una mesa.
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
					proxTiro.setTiroSalida(this.PUCK_PRENDIDO);
					
				}else{
					proxTiro.setTiroSalida(this.PUCK_APAGADO);
				}
				proxTiro.setPunto(this.punto);
			msgEstCraps.setProximoTiro(proxTiro);
			
					
			//seteo ultimo tiro (MSGUltimoTiro)
			MSGUltimoTiro ultTiro = new MSGUltimoTiro();
			ultTiro.setTirador(this.tiradorAnterior.getNombre());
			ultTiro.setResultado(this.ultimoResultado);
			List<MSGPremio> premios = new ArrayList<MSGPremio>();
			//premios...
			for (IJugador jug : jugadores){
				
				MSGPremio premio = new MSGPremio();
				//me fijo si el jugador tiene apuestas en la mesa
				for (ApuestaCraps ap : this.pagador.getApuestas()){
					
					if (ap.getApostador()== jug){
						
						premio.setApostador(jug.getNombre());
					}
					//montoPremioJugada -> FALTA;TODO a quien pedir
					//premio.setMontoPremioJugada(montoPremioJugada);
					//montoPremioJugadaFeliz-> FALTA;TODO a quien pedir
					//premio.setMontoPremioJugadaFeliz(montoPremioJugadaFeliz);
					//montoRetenidoJugadaTodosPonen -> FALTA;TODO a quien pedir
					//premio.setMontoRetenidoJugadaTodosPonen(montoRetenidoJugadaTodosPonen);
					premios.add(premio);
				}
				
			}
			//seteo apuestas vigentes (MSGApuestasVigentes)
			MSGApuestasVigentes apVigentes = new MSGApuestasVigentes();
			List<MSGApuesta> apuestas = new ArrayList<MSGApuesta>();
			//seteo a apVigentes los MSGApuesta
				for (ApuestaCraps apc : this.pagador.getApuestas()){
					
					MSGApuesta ap = new MSGApuesta();
					ap.setApostador(apc.getApostador().getNombre());
						//MSGOpcionApuesta
						MSGOpcionApuesta opAp = new MSGOpcionApuesta();
						opAp.setTipoApuesta(apc.getTipo());
						opAp.setPuntajeApostado(apc.getPuntaje());
					ap.setOpcionApuesta(opAp);
						//valorApuesta
						List<MSGValorFicha> valorFichas = new ArrayList<MSGValorFicha>();
						//TODO necesito las fichas apostadas y sus cantidades
					ap.setValorApuesta(valorFichas);
					
					apuestas.add(ap);
					
				}
			apVigentes.setApuestas(apuestas);
			msgEstCraps.setApuestasVigentes(apVigentes);
				
					
			return msgEstCraps;
		}	
}