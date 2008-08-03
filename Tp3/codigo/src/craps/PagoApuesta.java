package craps;

public final class PagoApuesta {

	
	public static String TRUE = "true";
	public static String FALSE = "false";
	public static String BOTTOM = "bottom";
	private int fichas;
	private int pago;

	public PagoApuesta(int fichas, int pago) {
		super();
		this.fichas = fichas;
		this.pago = pago;
	}
	
	public int getFichas() {
		return fichas;
	}
	
	public void setFichas(int fichas) {
		this.fichas = fichas;
	}
	
	public int getPago() {
		return pago;
	}
	
	public void setPago(int pago) {
		this.pago = pago;
	}
}
