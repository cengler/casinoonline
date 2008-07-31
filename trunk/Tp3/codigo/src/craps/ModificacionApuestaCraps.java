package craps;

public class ModificacionApuestaCraps {

	public static String TRUE = "true";
	public static String FALSE = "false";
	public static String BOTTOM = "bottom";
	
	private String tipo;
	private String puck;
	private int resultado;
	

	
	public ModificacionApuestaCraps(String tipo, String puck, int resultado) {
		super();
		this.tipo = tipo;
		this.puck = puck;
		this.resultado = resultado;
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
	
	public String toString() {
		return "(T: "+tipo+" P: "+puck+" R: "+resultado+")";
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
