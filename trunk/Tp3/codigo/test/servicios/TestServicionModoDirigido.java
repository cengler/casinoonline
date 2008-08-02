package servicios;

import org.apache.log4j.Logger;
import craps.SelectorResCrapsModoDirigido;
import casino.ISeteadorResultado;
import casino.ManejadorModoDirigido;
import casino.msg.MSGResultadosCrapsModo;
import casino.msg.MSGSetModo;

public class TestServicionModoDirigido {

	private static Logger logger = Logger.getLogger(TestServicionModoDirigido.class);
	
	public static void main(String[] args) {
		
		setModoDirigido();
	}
	
	public static void setModoDirigido()
	{
		MSGSetModo msg = new MSGSetModo();
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE SIN MODO");
		
		msg.setModo(MSGSetModo.NORMAL);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE EN MISMO MODO = MODO NORMAL");
		
		msg.setModo(MSGSetModo.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO");
		
		msg.setModo(MSGSetModo.NORMAL);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO NORMAL");
		
		MSGResultadosCrapsModo resCraps = new MSGResultadosCrapsModo(); 
		/*try {
			((List<ResultadoCraps>)resCraps.getResultados()).add(new ResultadoCraps(6, 6));
		} catch (CrapsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ // TODO
		
		msg.getResultados().add(resCraps);
		msg.setModo(MSGSetModo.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO CON 1 JUGADA >> NO HAY SETEADOR DE RES PARA CRAPS");
		
		ISeteadorResultado seter = SelectorResCrapsModoDirigido.getInstance();
		ManejadorModoDirigido.getInstance().getSeteadoresRes().add(seter);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO CON 1 JUGADA");
		
		msg.setModo(MSGSetModo.NORMAL);
		/*try {
		//	((List<ResultadoCraps>)resCraps.getResultados()).add(new ResultadoCraps(1, 1));
		//	((List<ResultadoCraps>)resCraps.getResultados()).add(new ResultadoCraps(1, 1));
		} catch (CrapsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ //TODO
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO NORMAL");
		
		msg.setModo(MSGSetModo.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		logger.error("  --- MENSAJE PASA A MODO DIRIGIDO CON 3 JUGADAS");
		
	}
	
}
