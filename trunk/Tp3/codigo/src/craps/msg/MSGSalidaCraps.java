package craps.msg;

public class MSGSalidaCraps extends MSGCraps {

		private int IdVirt;
		private String usuario;
		private int mesa; //la mesa no puede ser nula
		private String aceptado; //este atributo es para comunicarle al solicitante 
		//si su solicitud se acepto  o no
		private String descripcion; //es caso de no ser aceptada debe ir una descripcion
		//del motivo
		
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
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
	
}
