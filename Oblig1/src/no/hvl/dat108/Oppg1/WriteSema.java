package no.hvl.dat108.Oppg1;

import java.util.concurrent.Semaphore;

public class WriteSema extends Thread {
	
	private Semaphore sema;
	private Person person;
	private SirkulaerTabell tab;
	
	public WriteSema(Semaphore sema, Person person, SirkulaerTabell tab) {
		this.sema = sema;
		this.person = person;
		this.tab = tab;
	}
	
	@Override
    public void run() {
    	while (true) {
    		try {
				sema.acquire();
				if (person.erLest()) {
    				person.setNavn(tab.getNeste());
    				person.setErLest(false);
				}
				sema.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }

}
