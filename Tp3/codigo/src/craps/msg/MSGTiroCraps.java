package craps.msg;
import craps.msg.MSGResultadoCraps;

public class MSGTiroCraps extends MSGCraps {

	private int IdVirt;
	private String usuario;
	private int mesa; //la mesa no puede ser nula
	private String aceptado; //este atributo es para comunicarle al solicitante 
	//si su solicitud se acepto  o no
	private String tipoJugada;
	private MSGResultadoCraps  resultado;
	
	public String getAceptado() {
		return aceptado;
	}
	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}
	public int getIdVirt() {
		return IdVirt;
	}
	public void setIdVirt(int idVirt) {
		IdVirt = idVirt;
	}
	public int getmesa() {
		return mesa;
	}
	public void setmesa(int mesa) {
		this.mesa = mesa;
	}
	public MSGResultadoCraps getResultado() {
		return resultado;
	}
	public void setResultado(MSGResultadoCraps resultado) {
		this.resultado = resultado;
	}
	public String getTipoJugada() {
		return tipoJugada;
	}
	public void setTipoJugada(String tipoJugada) {
		this.tipoJugada = tipoJugada;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}