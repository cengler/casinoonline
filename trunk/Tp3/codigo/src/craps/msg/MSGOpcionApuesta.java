package craps.msg;
import craps.core.TipoApuestaCraps;

public class MSGOpcionApuesta {

	private TipoApuestaCraps tipoApuesta;
	private int puntajeApostado;
	
	public int getPuntajeApostado() {
		return puntajeApostado;
	}
	public void setPuntajeApostado(int puntajeApostado) {
		this.puntajeApostado = puntajeApostado;
	}
	public TipoApuestaCraps getTipoApuesta() {
		return tipoApuesta;
	}
	/*public void setTipoApuesta(TipoApuestaCraps tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
		// TODO
	}
	*/
	public void setTipoApuesta(String tipoApuesta) {
				
		this.tipoApuesta = TipoApuestaCraps.valueOf(tipoApuesta);
	
	
	}
	
}
