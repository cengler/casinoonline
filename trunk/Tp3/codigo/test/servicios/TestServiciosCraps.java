package servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import casino.Jugador;
import casino.ManejadorJugador;
import craps.ManejadorMesaCraps;
import craps.MesaCraps;
import craps.msg.MSGApostarCraps;
import craps.msg.MSGEntradaCraps;
import craps.msg.MSGOpcionApuesta;
import craps.msg.MSGTiroCraps;
import craps.msg.MSGValorFicha;
import craps.msg.TipoApuestaCraps;


public class TestServiciosCraps {

	private static Logger logger = Logger.getLogger(TestServiciosCraps.class);
	
	public static void main(String[] args) {
		//entrarCraps1();
		//entrarCraps2();
		//tirarCraps();
		apostarCraps();
	}
	
	public static void entrarCraps1()
	{
		MSGEntradaCraps mensaje = new MSGEntradaCraps();
		mensaje.setUsuario("pepe");
		mensaje.setVTerm("50");
		
		
		SrvCraps.entrarCraps(mensaje);
		
		/*// agrego a pepe
		Jugador pepe = new Jugador();
		pepe.setNombre("pepe");
		ManejadorJugador.getInstance().getJugadores().add(pepe);
		
		SrvCraps.entrarCraps(mensaje);
		
		pepe.setIdVirt(50);
		
		SrvCraps.entrarCraps(mensaje);
		
		pepe.setLogeado(true);
		
		SrvCraps.entrarCraps(mensaje);
		SrvCraps.entrarCraps(mensaje);*/
	}
	
	public static void entrarCraps2()
	{
		MSGEntradaCraps mensaje = new MSGEntradaCraps();
		mensaje.setUsuario("pepe");
		mensaje.setVTerm("50");
		mensaje.setMesa(20);
		
		// agrego a pepe
		Jugador pepe = new Jugador();
		pepe.setNombre("pepe");
		pepe.setIdVirt("50");
		pepe.setLogeado(true);
		ManejadorJugador.getInstance().getJugadores().add(pepe);
		
		SrvCraps.entrarCraps(mensaje);
		
		MesaCraps mesa = new MesaCraps(20);
		ManejadorMesaCraps.getInstance().getMesas().add(mesa);
		
		SrvCraps.entrarCraps(mensaje);
		
	}
	
	public static void tirarCraps(){
		
		
		MSGTiroCraps mensaje = new MSGTiroCraps();
		mensaje.setUsuario("pepe");
		mensaje.setVTerm("50");
		mensaje.setMesa(20);
		
		SrvCraps.tirarCraps(mensaje);
		
		Jugador pepe = new Jugador();
		pepe.setNombre("pepe");
		pepe.setIdVirt("50");
		pepe.setLogeado(true);
		ManejadorJugador.getInstance().getJugadores().add(pepe);
		
		Jugador juana = new Jugador();
		juana.setNombre("juana");
		juana.setIdVirt("50");
		juana.setLogeado(true);
		ManejadorJugador.getInstance().getJugadores().add(juana);
		
		SrvCraps.tirarCraps(mensaje);
		
		MesaCraps mesa = new MesaCraps(20);
		mesa.getJugadores().add(pepe);
		mesa.getJugadores().add(juana);
		mesa.setTirador(pepe);
		ManejadorMesaCraps.getInstance().getMesas().add(mesa);
		
		for (int i = 0; i<20; i++)
			SrvCraps.tirarCraps(mensaje);
		
		mesa.setTirador(pepe);
		
		
		//List<ResultadoCraps> l = new ArrayList<ResultadoCraps>();
		
		/*try {
			Casino.getInstance().setModoNormal(false);
			l.add(new ResultadoCraps(4, 4));
			l.add(new ResultadoCraps(4, 4));
			SelectorResCrapsModoDirigido.getInstance().setResultados(l);
		} 
		catch (Exception e) {
			logger.error("HICE MAL LA CONFIGURACION");
		}

		for (int i = 0; i<20; i++)
			SrvCraps.tirarCraps(mensaje);*/
		
		
	}
	
	public static void apostarCraps(){
		
		
		MSGApostarCraps mensaje = new MSGApostarCraps();
		mensaje.setUsuario("pepe");
		mensaje.setVTerm("50");
		mensaje.setMesa(20);
		
		SrvCraps.apostarCraps(mensaje);
		logger.info("EL JUGADOR NO ESTA EN EL CASINO");
		
		
		Jugador pepe = new Jugador();
		pepe.setNombre("pepe");
		pepe.setIdVirt("50");
		pepe.setLogeado(true);
		ManejadorJugador.getInstance().getJugadores().add(pepe);
		
		
		Jugador juana = new Jugador();
		juana.setNombre("juana");
		juana.setIdVirt("50");
		juana.setLogeado(true);
		
		ManejadorJugador.getInstance().getJugadores().add(juana);
		
		SrvCraps.apostarCraps(mensaje);
		logger.info("EL JUGADOR NO ESTA EN EL JUEGO");
		
		MesaCraps mesa = new MesaCraps(20);
		
		mesa.getJugadores().add(pepe);
		mesa.getJugadores().add(juana);
		mesa.setTirador(pepe);
		ManejadorMesaCraps.getInstance().getMesas().add(mesa);
		
		//seteo las fichas
		MSGOpcionApuesta op = new MSGOpcionApuesta();
		op.setPuntajeApostado(0);
		op.setTipoApuesta(TipoApuestaCraps.pase);
		mensaje.setOpcionApuesta(op);
		logger.info("antes de la lista");
		List<MSGValorFicha> list = new ArrayList<MSGValorFicha>();
		MSGValorFicha vf = new MSGValorFicha();
		vf.setCantidad(3);
		vf.setValor(1);
		MSGValorFicha vf1 = new MSGValorFicha();
		logger.info("nuevo MSGValorFicha");
		vf1.setCantidad(5);
		vf1.setValor(3);
		list.add(vf);
		list.add(vf1);
		
		mensaje.setValorApuesta(list);
		
		SrvCraps.apostarCraps(mensaje);
		
	}	
}
