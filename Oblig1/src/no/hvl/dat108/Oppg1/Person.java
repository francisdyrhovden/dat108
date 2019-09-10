package no.hvl.dat108.Oppg1;

public class Person {
	
	private StringBuffer navn;
	private boolean lest;
	
	public Person(String navn) {
		this.navn = new StringBuffer();
		this.navn.append(navn);
		lest = false;
	}
	
	public boolean erLest() {
		return lest;
	}
	
	public void setErLest(boolean lest) {
		this.lest = lest;
	}

	public String getNavn() {
		return navn.toString();
	}

	public void setNavn(String navn) {
		this.navn.delete(0, this.navn.length());
		this.navn.append(navn);
		
	}
	
}
