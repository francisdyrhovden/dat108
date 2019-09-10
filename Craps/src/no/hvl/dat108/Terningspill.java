package no.hvl.dat108;

import java.util.Scanner;

public class Terningspill {

	public void spill() {

		int antall;
		int kast1;
		int kast2;
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Skriv inn ditt navn");
		Spiller spiller = new Spiller(sc.next());

		while (run) {

			Terning terning1 = new Terning();
			Terning terning2 = new Terning();

			kast1 = terning1.trill();
			System.out.println("Du trilte: " + kast1);

			kast2 = terning2.trill();
			System.out.println("Du trilte: " + kast2);

			antall = kast1 + kast2;

			if (antall != 7) {
				System.out.println("Du har tapt");
			} else {
				System.out.println("Du har vunnet");
			}
			System.out.println("\nSpille mer? 1 for ja, 0 for nei");
			int svar = Integer.parseInt(sc.next());
			
			if (svar == 0) {
				run = false;
			}
		}
	}
}
