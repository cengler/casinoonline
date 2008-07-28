package casino;

public interface IJugador extends ICliente{

	int getIdVirt();

	boolean isLogeado();
	
	boolean isVip();

	boolean isModoObservador();

	String getNombre();

	int getSaldo();

}
