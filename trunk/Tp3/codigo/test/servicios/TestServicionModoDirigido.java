package servicios;

import craps.SelectorResCrapsModoDirigido;
import casino.ISeteadorResultado;
import casino.ManejadorModoDirigido;
import casino.msg.MSGResultadosCraps;
import casino.msg.MSGSetModoDirigido;

public class TestServicionModoDirigido {

	public static void main(String[] args) {
		
		setModoDirigido();
	}
	
	public static void setModoDirigido()
	{
		MSGSetModoDirigido msg = new MSGSetModoDirigido();
		SrvAdministracion.setModoDirigido(msg);
		
		msg.setModo(MSGSetModoDirigido.NORMAL);
		SrvAdministracion.setModoDirigido(msg);
		
		msg.setModo(MSGSetModoDirigido.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		msg.setModo(MSGSetModoDirigido.NORMAL);
		SrvAdministracion.setModoDirigido(msg);
		
		MSGResultadosCraps resCraps = new MSGResultadosCraps(); 
		resCraps.getResultados().add(new Integer(6));
		System.out.println( resCraps.getResultados() );
		
		msg.getResultados().add(resCraps);
		msg.setModo(MSGSetModoDirigido.DIRIGIDO);
		SrvAdministracion.setModoDirigido(msg);
		
		ISeteadorResultado seter = SelectorResCrapsModoDirigido.getInstance();
		ManejadorModoDirigido.getInstance().getSeteadoresRes().add(seter);
		SrvAdministracion.setModoDirigido(msg);
		
		
	}
	
}
