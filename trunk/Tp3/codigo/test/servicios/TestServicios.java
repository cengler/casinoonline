package servicios;

import casino.msg.MSGAbrirCasino;

public class TestServicios {


	public static void main(String[] args) {
		
		abrirCasino();
	}
	
	public static void abrirCasino()
	{
		SrvAdministracion.abrirCasino(new MSGAbrirCasino());
		//MSGAbrirCasino m = ManejadorCasino.getInstance().abrirCasino(new MSGAbrirCasino());
	}

}
