package tipoJugada;

import craps.MesaCraps;
import casino.Casino;
import casino.IMesa;
import casino.ISeleccionadorTipoJugada;
import casino.SeleccionadorTipoJugadaPorModo;
import casino.TipoJugada;

public class TestTipoJugada {

	public static void main(String[] args) {
		
		ISeleccionadorTipoJugada s = SeleccionadorTipoJugadaPorModo.getInstance();
		
		IMesa mesa = new MesaCraps();
		((MesaCraps)mesa).setId(20);
		
		System.out.println("MODO NORMAL: " + Casino.getInstance().isModoNormal());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		
		Casino.getInstance().setModoNormal(false);
		
		System.out.println("MODO NORMAL: " + Casino.getInstance().isModoNormal());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
		System.out.println(s.getTipoJugada(mesa).name());
	}
}
