package no.hvl.dat108;

import java.util.Random;

public class Terning {
	
	private int verdi;
	
	public Terning() {
		
	}
	
	public int trill() {
		Random rand = new Random();
		verdi = rand.nextInt(6) + 1;
		
		return verdi;
	}

}
