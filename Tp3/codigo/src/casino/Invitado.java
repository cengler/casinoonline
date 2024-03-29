package casino;


/**
 * Clase invitado, representa a los loggeados no clientes del casino.
 * 
 * @author Grupo2
 *
 */
public class Invitado implements IInvitado {

	private String idVirt;
	private String nombre;
	//private Logger logger = Logger.getLogger(Jugador.class);
	
	/**
	 * Constructor.
	 */
	public Invitado()
	{
		idVirt = "";
		nombre = "";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIdVirt() {
		return idVirt;
	}

	public void setIdVirt(String idVirt) {
		this.idVirt = idVirt;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * El hashCode de invitados esta dada por el nombre.
	 */
	public int hashCode() {
		return nombre.hashCode();
	}

	/**
	 * La igualdad de invitados esta dada por el nombre.
	 */
	public boolean equals(Object jug)
	{
		if (jug instanceof Jugador)
            return this.nombre.equals(((Jugador)jug).getNombre());
        else
            return false;
	}
}
