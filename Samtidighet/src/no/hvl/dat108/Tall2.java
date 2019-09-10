package no.hvl.dat108;

/**
 * Lager en tall-klasse ettersom Integer ikke kan brukes her.
 * 
 * @author Atle Geitung
 */
public class Tall2 {
    
    private int verdi;

    public Tall2(int verdi) {
        this.verdi = verdi;
    }

    synchronized public int inkrement() {
        verdi++;
        return verdi;
    }

    @Override
    public String toString() {
        return "" + verdi;
    }
}
