package craps;

public class ResultadoCraps {

	private int dado1;
	private int dado2;
	
	public ResultadoCraps(int d1, int d2){
		
		dado1 = d1;
		dado2 = d2;
		
	}
	
	public ResultadoCraps getResult(){
		
		return this;
	}
	
	public int getDado1() {
		return dado1;
	}
	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}
	public int getDado2() {
		return dado2;
	}
	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}
	
	
	
}
