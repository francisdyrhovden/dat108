package no.hvl.dat108;

/**
 * Viser bruk av synchronize.
 * 
 * @author Atle Geitung
 */
public class Eksempel2_MedSynchronized {
    
    private static Tall2 deltTeller = new Tall2(0);

    /**
     * @param args ikke i bruk
     * @throws InterruptedException 
     */
    public static void main(String[] args) {
        Thread teller1 = new TelleThreadSynchronized(deltTeller);
        Thread teller2 = new TelleThreadSynchronized(deltTeller);
        Thread teller3 = new TelleThreadSynchronized(deltTeller);

        teller1.start();
        teller2.start();
        teller3.start();
    }
}
