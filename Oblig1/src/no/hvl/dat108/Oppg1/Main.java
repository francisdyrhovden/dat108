package no.hvl.dat108.Oppg1;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		SirkulaerTabell tab = new SirkulaerTabell();
		Person person = new Person("Adam");
		Semaphore sema = new Semaphore(1);
		
//		Thread lese1 = new ReadSync(person, tab);
//		Thread lese2 = new ReadSync(person, tab);
//		Thread lese3 = new ReadSync(person, tab);
//		Thread lese4 = new ReadSync(person, tab);
//		Thread lese5 = new ReadSync(person, tab);
//		
//		Thread skrive1 = new WriteSync(person, tab);
//		Thread skrive2 = new WriteSync(person, tab);
//		Thread skrive3 = new WriteSync(person, tab);
//		Thread skrive4 = new WriteSync(person, tab);
//		Thread skrive5 = new WriteSync(person, tab);
		
		Thread lese1 = new ReadSema(sema, person, tab);
		Thread lese2 = new ReadSema(sema, person, tab);
		Thread lese3 = new ReadSema(sema, person, tab);
		Thread lese4 = new ReadSema(sema, person, tab);
		Thread lese5 = new ReadSema(sema, person, tab);
		
		Thread skrive1 = new WriteSema(sema, person, tab);
		Thread skrive2 = new WriteSema(sema, person, tab);
		Thread skrive3 = new WriteSema(sema, person, tab);
		Thread skrive4 = new WriteSema(sema, person, tab);
		Thread skrive5 = new WriteSema(sema, person, tab);
		
		lese1.start();
		lese2.start();
		lese3.start();
		lese4.start();
		lese5.start();
		
		skrive1.start();
		skrive2.start();
		skrive3.start();
		skrive4.start();
		skrive5.start();
		
	}

}
