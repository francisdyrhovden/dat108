package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;

public class Eksempel6 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		/*
		 * Dette eksemplet viser en del vanlige
		 * terminal operations.
		 */

		// forEach har vi sett en del p� f�r
		// collect har vi sett eksempel p� f�r
		
		//reduce
		String a = people.stream()	
				.map(p -> p.getFirstName().substring(0, 1))
				.reduce("", (acc, s) -> acc + s);
		System.out.println(a);
		
		//count
		long antall = people.stream().count();
		System.out.println(antall);
		
		// anyMatch, allMatch, noneMatch
		boolean match = people.stream().allMatch(p -> p.getAge() > 30);
		System.out.println(match);

	}

}




