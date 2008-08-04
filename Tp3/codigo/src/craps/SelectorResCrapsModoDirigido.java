package craps;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import casino.CasinoException;
import casino.ISeteadorResultado;
import casino.msg.MSGResultadoCrapsModo;
import casino.msg.MSGResultadoModo;

/**
 * SelectorResCrapsModoDirigido.
 * 
 * @author Grupo2.
 *
 */
public class SelectorResCrapsModoDirigido implements ISelectorResCraps, ISeteadorResultado {

	public static String SEL_RES_NAME = "craps";
	private static SelectorResCrapsModoDirigido instance;
	private List<MSGResultadoCrapsModo> resultados;
	private int resActual = 0;
	private Logger logger = Logger.getLogger(SelectorResCrapsModoDirigido.class);
	
	/**
	 * Constructor.
	 */
	private SelectorResCrapsModoDirigido()
	{
		resultados = new ArrayList<MSGResultadoCrapsModo>();
	}
	
	/**
	 * Obtiene la unica instancia del SelectorResCrapsModoDirigido;
	 * @return
	 */
	public static SelectorResCrapsModoDirigido getInstance(){
		if(instance == null)
			instance = new SelectorResCrapsModoDirigido();
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	public ResultadoCraps getResult() 
	{
		ResultadoCraps res = new ResultadoCraps();
		if(resultados.size() < 1)
		{
			logger.error("No se ha seteado ningun resultado para el modo dirigido");
			//TODO throw new CraspEx
		}
		res.setDado1(resultados.get(resActual).getDado1());
		res.setDado2(resultados.get(resActual).getDado2());
		
		if(resActual == (resultados.size() - 1))
			resActual = 0;
		else
			resActual++;
		
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setResultados(List<MSGResultadoModo> lista) throws CasinoException
	{	
		if(lista == null || lista.size() == 0)
		{
			logger.error("La lista de resultados a setear debe contener al menos un resultado");
			throw new CasinoException("La lista de resultados a setear debe contener al menos un resultado");
		}
		resultados = new ArrayList<MSGResultadoCrapsModo>();
		for(Object o : lista)
		{
			if(o instanceof MSGResultadoCrapsModo)
			{
				logger.debug("Agregando res: " + o);
				resultados.add((MSGResultadoCrapsModo)o);
			}
			else
			{
				logger.error("Los resultados a seter para craps deben ser: " + MSGResultadoCrapsModo.class + " y son: " + o.getClass());
				throw new CasinoException("Los resultados a seter para craps deben ser: " + MSGResultadoCrapsModo.class + " y son: " + o.getClass() );
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return SEL_RES_NAME;
	}

	public void borrarResultadosSeteados() {
		resultados.clear();
		resActual = 0;
	}

}