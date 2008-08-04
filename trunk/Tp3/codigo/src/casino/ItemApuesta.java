package casino;

public class ItemApuesta {

	private int ficha;
	private int cantidad;

	public ItemApuesta(int ficha, int cantidad) {
		super();
		this.ficha = ficha;
		this.cantidad = cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getFicha() {
		return ficha;
	}
	public void setFicha(int ficha) {
		this.ficha = ficha;
	}
	
	
}
