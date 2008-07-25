package casino;

import java.util.List;

/**
 * ManejadorInvitado.
 * 
 * @author Grupo2
 *
 */
public class ManejadorInvitado {

	private List<Invitado> invitados;
	private static ManejadorInvitado instance;

	/**
	 * Constructor.
	 */
	private ManejadorInvitado(){}
	
	/**
	 * Obtiene la unica instancia de la clase.
	 * 
	 * @return la unica instancia de la clase.
	 */
	public static ManejadorInvitado getInstance()
	{
		if(instance == null)
			instance = new ManejadorInvitado();
		return instance; 
	}

	/**
	 * Obtiene la lista de invitados.
	 * 
	 * @return la lista de invitados.
	 */
	public List<Invitado> getInvitados() {
		return invitados;
	}

	/**
	 * Setea la lista de invitados.
	 * 
	 * @param invitados la lista de invitados a setear.
	 */
	public void setInvitados(List<Invitado> invitados) {
		this.invitados = invitados;
	}

}
