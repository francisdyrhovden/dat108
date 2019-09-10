package no.hvl.dat108.Oppg1;

public class ReadSync extends Thread {
	
	private Person person;
	private SirkulaerTabell tab;
	
	public ReadSync(Person person, SirkulaerTabell tab) {
		super();
		this.person = person;
		this.tab = tab;
    }

    @Override
    public void run() {
        
    	while (true) {
    		synchronized (person) {
    			if (!person.erLest()) {
    				person.setErLest(true);
    				System.out.println(person.getNavn());
    				tab.getNeste();
        			person.notifyAll();
    			} else {
    				try {
    					person.wait();
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    			}
    		}
    	}
    }
}
