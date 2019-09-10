package no.hvl.dat108.Oppg1;

public class SirkulaerTabell {
	
	int posisjon;
	String[] tab = {"Per","Ole", "Francis","Hans","Knut"};
	
	public SirkulaerTabell() {
		posisjon = 0;
	}
	
	public String getNavn() {
		return tab[posisjon];
	}
	
	public String getNeste(){
		posisjon = (posisjon+1) % tab.length;
		return tab[posisjon];
	}
}