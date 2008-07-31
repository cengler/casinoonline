package casino.msg;

import java.util.List;

public class MSGEntradaCasino extends MSGCasino {

	
	private int vTerm;
	private String usuario;
	private String descripcion;
	private String modoAcceso;
	private int saldo;
	private String aceptado;
	List<Integer> fichasHabilitadas;
	
	
	public String getAceptado() {
		return aceptado;
	}
	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModoAcceso() {
		return modoAcceso;
	}
	public void setModoAcceso(String modoAcceso) {
		this.modoAcceso = modoAcceso;
	}
	public int getSaldo() {
		return saldo;	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public List<Integer> getFichasHabilitadas() {
		return fichasHabilitadas;
	}
	public void setFichasHabilitadas(List<Integer> fichasHabilitadas) {
		this.fichasHabilitadas = fichasHabilitadas;
	}
	
	public int getVTerm() {
		return vTerm;
	}
	public void setVTerm(int term) {
		vTerm = term;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

}