package casino;

public class Invitado implements IInvitado {

	private int idVirt;
	private String nombre;

	public Invitado(){

	}

	public int getIdVirt() {
		return idVirt;
	}

	public void setIdVirt(int idVirt) {
		this.idVirt = idVirt;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}