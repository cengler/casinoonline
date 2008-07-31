package craps;


public class ResultadoApuestaCraps {

	public static String TRUE = "true";
	public static String FALSE = "false";
	public static String BOTTOM = "bottom";
	
	private String tipo;
	private String puck;
	private int resultado;
	private int apuesta;
	
	public int getApuesta() {
		return apuesta;
	}
	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
	public String getPuck() {
		return puck;
	}
	public void setPuck(String puck) {
		this.puck = puck;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ResultadoApuestaCraps(String tipo, String puck, int resultado, int apuesta) {
		super();
		this.tipo = tipo;
		this.puck = puck;
		this.resultado = resultado;
		this.apuesta = apuesta;
	}

	public String toString() {
		return "(T: "+tipo+" P: "+puck+" R: "+resultado+" A:"+apuesta+")";
	}

	public boolean equals(Object res)
	{
		boolean igual = true;
		
		if (res instanceof ResultadoApuestaCraps)
		{
			ResultadoApuestaCraps resC = (ResultadoApuestaCraps)res;
			
			igual = igual && tipo.equals( resC.getTipo());
			igual = igual && (resultado == resC.getResultado());
			
			if(puck.equals(TRUE))
				igual = igual && (!resC.getPuck().equals(FALSE));
			else if(puck.equals(FALSE))
				igual = igual && (!resC.getPuck().equals(TRUE));
			
			if(apuesta != -1)
			{
				igual = igual && ((apuesta == resC.apuesta) || resC.apuesta == -1);
			}
		}
		else
			igual = false;
		return igual;
	}

	public int hashCode()
	{
		return tipo.hashCode() + resultado;
	}
	
	
	
}
