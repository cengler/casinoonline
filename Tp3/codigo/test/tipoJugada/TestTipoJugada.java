package tipoJugada;

import casino.Casino;
import casino.IMesa;
import casino.ISeleccionadorTipoJugada;
import casino.SeleccionadorTipoJugadaPorModo;
import craps.MesaCraps;

public class TestTipoJugada {

	public static void main(String[] args) {
		
		ISeleccionadorTipoJugada s = SeleccionadorTipoJugadaPorModo.getInstance();
		
		IMesa mesa = new MesaCraps();
		((MesaCraps)mesa).setId(20);
		
		System.out.println("MODO NORMAL: " + Casino.getInstance().isModoNormal());
		s.getTipoJugada(mesa);
		s.getTipoJugada(mesa);
		s.getTipoJugada(mesa);
		s.getTipoJugada(mesa);
		
		Casino.getInstance().setModoNormal(false);
		
		System.out.println("MODO NORMAL: " + Casino.getInstance().isModoNormal());
		s.getTipoJugada(mesa);
		s.getTipoJugada(mesa);
		s.getTipoJugada(mesa);
		s.getTipoJugada(mesa);
	}
}
