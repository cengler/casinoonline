package casino;

import java.util.List;

import casino.msg.MSGResultadoModo;

public interface ISeteadorResultado {

	void setResultados(List<MSGResultadoModo> lista) throws CasinoException;
	
	void borrarResultadosSeteados();
	
	String getName();
}
