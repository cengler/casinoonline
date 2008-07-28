package casino;

/**
 * Interface de un jugador invitado. 
 * Para limitar a los clientes de la manipulacion erronea del invitado
 * 
 * @author Grupo2
 *
 */
public interface IInvitado extends ICliente {

	/**
	 * Geter del id de la terminal virtual desde la cual
	 * se conecta el cliente invitado.
	 * 
	 * @return el id de la terminal virtual
	 */
	int getIdVirt();
	
	/**
	 * Geter del nombre del invitado.
	 * 
	 * @return el nombre del invitado
	 */
	String getNombre();

}
