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
		int indiceActual = 0;

		if(tiradorActual == null)
		{
			logger.error("El tirador de la mesa esta en NULL y siempre deberia haber un tirador");
			//throw new CrapsException("El tirador de la mesa esta en NULL y siempre deberia haber un tirador");
			// TODO LUEGO AGREGAR
		}
		else if(mesa.getJugadores().size() < 1)
		{
			logger.error("Debe haber jugadores en la mesa, la mesa deberia estar cerrada");
			//throw new CrapsException("Debe haber jugadores en la mesa, la mesa deberia estar cerrada");
			// TODO LUEGO AGREGAR
		}
		else if( !mesa.getJugadores().contains(tiradorActual))
		{
			logger.debug("TiradorActual: " + tiradorActual + " Jugadores: " + mesa.getJugadores());
			logger.error("El tirador actual debe ser un jugador");
			//throw new CrapsException("El tirador actual debe ser un jugador");
			// TODO LUEGO AGREGAR
		}else
		{
			indiceActual = mesa.getJugadores().indexOf(tiradorActual);
			if(indiceActual == (mesa.getJugadores().size() - 1))
				indiceActual = 0;
			else
				indiceActual++;
		}
		return mesa.getJugadores().get(indiceActual);
	}

}