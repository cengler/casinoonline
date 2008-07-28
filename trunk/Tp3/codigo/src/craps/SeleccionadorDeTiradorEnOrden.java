package craps;

import org.apache.log4j.Logger;

import casino.IJugador;

public class SeleccionadorDeTiradorEnOrden implements ISeleccionadorDeTirador {

	Logger logger = Logger.getLogger(SeleccionadorDeTiradorEnOrden.class);
	private static SeleccionadorDeTiradorEnOrden  instance;
	
	public static SeleccionadorDeTiradorEnOrden  getInstance(){
		if(instance == null)
			instance = new SeleccionadorDeTiradorEnOrden ();
		return instance;
	}
	public SeleccionadorDeTiradorEnOrden(){}

	public IJugador getProxTirador(MesaCraps mesa)
	{
		// DEBERIA SEGUIR ESTANDO EN EL JUEGO 
		// PUES NO SE PUEDE RETIRAR SI ES EL TIRADOR
		IJugador tiradorActual = mesa.getTirador();

		if(tiradorActual == null)
		{
			logger.error("El tirador de la mesa esta en NULL y siempre deberia haber un tirador");
			//throw new CrapsException("El tirador de la mesa esta en NULL y siempre deberia haber un tirador");
			// TODO LUEGO AGREGAR
		}
		else
		{
			boolean elSig = false;
			for(IJugador jugador : mesa.getJugadores())
			{
				if(elSig)
				{
					return jugador;
				}
				else if(jugador.equals(tiradorActual))
				{
					elSig = true;
				}
			}
		}
		logger.fatal("Ha ocurrido un error grave al obtener el proximo tirador");
		return null;
	}

}