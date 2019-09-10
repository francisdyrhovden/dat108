package no.hvl.dat108.Oppg1;

import java.util.concurrent.Semaphore;

public class ReadSema extends Thread {
	
	private Semaphore sema;
	private Person person;
	private SirkulaerTabell tab;

	
	public ReadSema(Semaphore sema, Person person, SirkulaerTabell tab) {
		this.sema = sema;
		this.person = person;
		this.tab = tab;
		
    }

    @Override
    public void run() {
        
    	while (true) {
    		try {
				sema.acquire();
				if (!person.erLest()) {
					person.setErLest(true);
					System.out.println(person.getNavn());
					tab.getNeste();
				}
				sema.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
    	}
    }
   
}
