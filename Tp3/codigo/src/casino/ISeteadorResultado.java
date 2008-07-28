package casino;

import java.util.List;

public interface ISeteadorResultado {

	void setResultados(List< ? > lista) throws CasinoException;
	
	List< ? > getResultados();
	
	String getName();
}
