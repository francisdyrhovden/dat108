package no.hvl.dat108;

/**
 * Tråd som øker en teller med en og skriver den ut.
 * 
 * @author Atle Geitung
 */
public class TelleThreadSynchronized extends Thread {
    private Tall2 teller;

    /**
     * @param teller
     */
    public TelleThreadSynchronized(Tall2 teller) {
        this.teller = teller;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            teller.inkrement();
            System.out.println(teller);
        }

    }

}
