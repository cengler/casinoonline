package casino;

public abstract class Cliente {
	
	protected String nombre;
	protected String idVirt;
	
	public String getIdVirt() {
		return idVirt;
	}
	public void setIdVirt(String idVirt) {
		this.idVirt = idVirt;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
