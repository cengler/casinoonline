package craps;

import casino.IJugador;
import casino.IMesa;

public interface ISeleccionadorDeTirador {

	public IJugador getProxTirador(IMesa mesa);

}