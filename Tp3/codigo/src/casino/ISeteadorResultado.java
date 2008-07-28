package casino;

import java.util.List;

public interface ISeteadorResultado {

	void setResultados(List<Object> lista) throws CasinoException;
	
	String getName();
}
