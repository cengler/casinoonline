package craps;

import casino.IJugador;
import casino.IMesa;

public interface ISeleccionadorDeTirador {

	IJugador getProxTirador(IMesa mesa);

}