package casino.msg.estadoCasino;

import java.util.List;

public class MSGTragamonedas implements IMSGJuego {

	private int pozoProgresivo;
	private List<MSGMesaTragamonedas> mesasTragamonedas;
	
	public int getPozoProgresivo() {
		return pozoProgresivo;
	}
	public void setPozoProgresivo(int pozoProgresivo) {
		this.pozoProgresivo = pozoProgresivo;
	}
	public List<MSGMesaTragamonedas> getMesasTragamonedas() {
		return mesasTragamonedas;
	}
	public void setMesasTragamonedas(List<MSGMesaTragamonedas> mesasTragamonedas) {
		this.mesasTragamonedas = mesasTragamonedas;
	}
	
	
}
