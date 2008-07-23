package servicios;

import casino.msg.MSGAbrirCasino;
import casino.msg.MSGCerrarCasino;

public class TestServicios {


	public static void main(String[] args) {
		
		abrirCasino();
		cerrarCasino();
	}
	
	public static void abrirCasino()
	{
		SrvAdministracion.abrirCasino(new MSGAbrirCasino());
	}

	public static void cerrarCasino()
	{
		SrvAdministracion.cerrarCasino(new MSGCerrarCasino());
	}

}
