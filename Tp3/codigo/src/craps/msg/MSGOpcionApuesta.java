package craps.msg;

public class MSGOpcionApuesta {

	private String tipoApuesta;
	private int puntajeApostado;
	
	public int getPuntajeApostado() {
		return puntajeApostado;
	}
	public void setPuntajeApostado(int puntajeApostado) {
		this.puntajeApostado = puntajeApostado;
	}
	public String getTipoApuesta() {
		return tipoApuesta;
	}
	public void setTipoApuesta(String tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}
	
	
}
