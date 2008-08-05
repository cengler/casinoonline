package craps;

import java.util.ArrayList;
import java.util.List;

import casino.IJugador;
import craps.msg.MSGApuesta;
import craps.msg.MSGApuestasVigentes;
import craps.msg.MSGEstadoCraps;
import craps.msg.MSGJugadorCraps;
import craps.msg.MSGOpcionApuesta;
import craps.msg.MSGPremio;
import craps.msg.MSGProxTiro;
import craps.msg.MSGUltimoTiro;
import craps.msg.MSGValorFicha;

public class FotografiableCraps {

	MesaCraps mesa; 
	
	public FotografiableCraps(MesaCraps mesa)
	{
		this.mesa = mesa;
	}

	public MSGEstadoCraps sacarFoto()
	{		
		MSGEstadoCraps msgEstCraps = new MSGEstadoCraps();  
		List<MSGJugadorCraps> lsJugC = new ArrayList<MSGJugadorCraps>();
		// seteo los jugadores de la mesa
		for (IJugador j : mesa.getJugadores())
		{

			MSGJugadorCraps msgJug = new MSGJugadorCraps(); 
			msgJug.setJugador(j.getNombre());
			lsJugC.add(msgJug);
		}
		msgEstCraps.setJugadores(lsJugC);
		// seteo proximo tiro (MSGProxTiro)
		MSGProxTiro proxTiro = new MSGProxTiro();

		proxTiro.setTirador(mesa.getTirador().getNombre());
		if (mesa.isPuck()== true){ // puck prendido
			proxTiro.setTiroSalida(MesaCraps.PUCK_PRENDIDO);

		}else{
			proxTiro.setTiroSalida(MesaCraps.PUCK_APAGADO);
		}
		proxTiro.setPunto(mesa.getPunto());
		msgEstCraps.setProximoTiro(proxTiro);


		// seteo ultimo tiro (MSGUltimoTiro)
		MSGUltimoTiro ultTiro = new MSGUltimoTiro();
		ultTiro.setTirador(mesa.getTiradorAnterior().getNombre());
		ultTiro.setResultado(mesa.getUltimoResultado());
		List<MSGPremio> premios = new ArrayList<MSGPremio>();
		// premios...
		for (IJugador jug : mesa.getJugadores()){

			MSGPremio premio = new MSGPremio();
			// me fijo si el jugador tiene apuestas en la mesa
			for (ApuestaCraps ap : mesa.getPagador().getApuestas()){

				if (ap.getApostador()== jug){

					premio.setApostador(jug.getNombre());
				}

				premio.setMontoPremioJugada(ap.getGananciaBruta());
				premio.setMontoPremioJugadaFeliz(ap.getMontoPremioJugadaFeliz());
				premio.setMontoRetenidoJugadaTodosPonen(ap.getMontoRetenidoJugadaTodosPonen());
				premios.add(premio);
			}

		}
		// seteo apuestas vigentes (MSGApuestasVigentes)
		MSGApuestasVigentes apVigentes = new MSGApuestasVigentes();
		List<MSGApuesta> apuestas = new ArrayList<MSGApuesta>();
		// seteo a apVigentes los MSGApuesta
		for (ApuestaCraps apc : mesa.getPagador().getApuestas()){

			MSGApuesta ap = new MSGApuesta();
			ap.setApostador(apc.getApostador().getNombre());
			// MSGOpcionApuesta
			MSGOpcionApuesta opAp = new MSGOpcionApuesta();
			opAp.setTipoApuesta(apc.getTipo());
			opAp.setPuntajeApostado(apc.getPuntaje());
			ap.setOpcionApuesta(opAp);
			// valorApuesta
			List<MSGValorFicha> valorFichas = new ArrayList<MSGValorFicha>();
			// TODO necesito las fichas apostadas y sus cantidades
			ap.setValorApuesta(valorFichas);

			apuestas.add(ap);

		}
		apVigentes.setApuestas(apuestas);
		msgEstCraps.setApuestasVigentes(apVigentes);


		return msgEstCraps;
	}
}