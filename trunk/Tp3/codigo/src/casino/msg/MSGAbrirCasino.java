package casino.msg;

import java.util.List;

public class MSGAbrirCasino extends MSGAdministracion {

	public MSGAbrirCasino(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/*public MSGProbaCraps getProbaCraps(){
		return null;
	}*/

	public int getProbaJugadaFeliz(){
		return 0;
	}

	public int getProbaJugadaNormal(){
		return 0;
	}

	public int getProbaJugadaTodosPonen(){
		return 0;
	}

	/*public MSGProbaTraga getProbaTraga(){
		return null;
	}*/

	public List<Integer> getValorFicha(){
		return null;
	}

}