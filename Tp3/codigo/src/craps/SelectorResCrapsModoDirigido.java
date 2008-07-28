package craps;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import casino.CasinoException;
import casino.ISeteadorResultado;

/**
 * SelectorResCrapsModoDirigido.
 * 
 * @author Grupo2.
 *
 */
public class SelectorResCrapsModoDirigido implements ISelectorResCraps, ISeteadorResultado {

	public static String SEL_RES_NAME = "craps";
	private static SelectorResCrapsModoDirigido instance;
	private List<ResultadoCraps> resultados;
	private int resActual = 0;
	private Logger logger = Logger.getLogger(SelectorResCrapsModoDirigido.class);
	
	/**
	 * Constructor.
	 */
	private SelectorResCrapsModoDirigido()
	{
		resultados = new ArrayList<ResultadoCraps>();
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
	public ResultadoCraps getResult() {
		
		ResultadoCraps res = null;
		if(resActual < resultados.size())
		{
			res = resultados.get(resActual);
			if(resActual == (resultados.size() - 1))
				resActual = 0;
			else
				resActual++;
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setResultados(List<Object> lista) throws CasinoException
	{
		resActual = lista.size();
		
		resultados = new ArrayList<ResultadoCraps>();
		for(Object o : lista)
		{
			if(o instanceof ResultadoCraps)
				resultados.add((ResultadoCraps)o);
			else
			{
				logger.error("Los resultados a seter para craps deben ser :" + ResultadoCraps.class);
				throw new CasinoException("Los resultados a seter para craps deben ser :" + ResultadoCraps.class);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return SEL_RES_NAME;
	}

}