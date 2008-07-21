package craps.msg;

public class MSGCraps {

	private boolean aceptado;
	private int inVirt;
	private String mesa;
	private String nombre;
	
	public boolean isAceptado() {
		return aceptado;
	}
	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}
	public int getInVirt() {
		return inVirt;
	}
	public void setInVirt(int inVirt) {
		this.inVirt = inVirt;
	}
	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}