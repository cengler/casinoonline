package casino;

public interface IJugador extends ICliente{

	public int getIdVirt();

	public boolean isLogeado();
	
	public boolean isVip();

	public boolean isModoObservador();

	public String getNombre();

	public int getSaldo();

}
