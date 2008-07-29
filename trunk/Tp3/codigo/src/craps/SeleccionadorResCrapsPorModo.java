package craps;

import casino.Casino;

/**
 * SeleccionadorResCrapsPorModo.
 * 
 * @author Grupo2
 *
 */
public class SeleccionadorResCrapsPorModo implements ISeleccionadorResCraps 
{
	//private static Logger logger = Logger.getLogger(SeleccionadorResCrapsPorModo.class);
	private static SeleccionadorResCrapsPorModo instance;
	
	/**
	 * Constructor.
	 */
	public SeleccionadorResCrapsPorModo(){}
	
	/**
	 * Obtiene la unica instancia de SeleccionadorResCrapsPorModo.
	 * 
	 * @return la unica instancia de SeleccionadorResCrapsPorModo.
	 */
	public static SeleccionadorResCrapsPorModo getInstance(){
		if(instance == null)
			instance = new SeleccionadorResCrapsPorModo();
		return instance;
	}

	/**
	 * Obtiene en resultado craps dependiendo el modo en que este el casino.
	 * De todas maneras la eleccion de que resultado saldrá, dependerá del
	 * selector de resultado elegido por este selector.
	 * 
	 * @return el resultado calculado
	 */
	public ResultadoCraps getResult()
	{
		ISelectorResCraps selector = null; 
		if(Casino.getInstance().isModoNormal())
			selector = SelectorResCrapsModoNormal.getInstance();
		else
			selector = SelectorResCrapsModoDirigido.getInstance();
		
		ResultadoCraps res = selector.getResult();
		
		return res;
	}
}

