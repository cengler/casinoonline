package servicios;

import java.util.List;

import org.apache.log4j.Logger;

import craps.CrapsException;
import craps.ResultadoCraps;
import craps.SelectorResCrapsModoDirigido;
import casino.ISeteadorResultado;
import casino.ManejadorModoDirigido;
import casino.msg.MSGResultadosCraps;
import casino.msg.MSGSetModoDirigido;

public class TestServicionModoDirigido {

	private static Logger logger = Logger.getLogger(TestServicionModoDirigido.class);
	
	public static void main(String[] args) {
		
		setModoDirigido();
	}
	
	public static void setModoDirigido()
	{
		MSGSetModoDirigido msg = new MSGSetModoDirigido();
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE SIN MODO");
		
		msg.setModo(MSGSetModoDirigido.NORMAL);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE EN MISMO MODO = MODO NORMAL");
		
		msg.setModo(MSGSetModoDirigido.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO");
		
		msg.setModo(MSGSetModoDirigido.NORMAL);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO NORMAL");
		
		MSGResultadosCraps resCraps = new MSGResultadosCraps(); 
		try {
			((List<ResultadoCraps>)resCraps.getResultados()).add(new ResultadoCraps(6, 6));
		} catch (CrapsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		msg.getResultados().add(resCraps);
		msg.setModo(MSGSetModoDirigido.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO CON 1 JUGADA >> NO HAY SETEADOR DE RES PARA CRAPS");
		
		ISeteadorResultado seter = SelectorResCrapsModoDirigido.getInstance();
		ManejadorModoDirigido.getInstance().getSeteadoresRes().add(seter);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO CON 1 JUGADA");
		
		msg.setModo(MSGSetModoDirigido.NORMAL);
		try {
			((List<ResultadoCraps>)resCraps.getResultados()).add(new ResultadoCraps(1, 1));
			((List<ResultadoCraps>)resCraps.getResultados()).add(new ResultadoCraps(1, 1));
		} catch (CrapsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO NORMAL");
		
		msg.setModo(MSGSetModoDirigido.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO CON 3 JUGADAS");
		
	}
	
}
