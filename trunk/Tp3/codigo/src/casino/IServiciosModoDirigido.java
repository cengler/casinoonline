package casino;

import casino.msg.MSGResetModoDirigido;
import casino.msg.MSGSetJugada;
import casino.msg.MSGsetModoDirigido;

public interface IServiciosModoDirigido {

	public abstract MSGResetModoDirigido resetModoDirigido(MSGResetModoDirigido mensaje);

	public abstract MSGSetJugada setearJugada(MSGSetJugada mensaje);

	public abstract MSGsetModoDirigido setModoDirigido(MSGsetModoDirigido mensaje);

}