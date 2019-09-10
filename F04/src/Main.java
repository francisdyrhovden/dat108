import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listen = Arrays.asList("Hallo", "blabla", "knut", "Per");
		
		//1
		Collections.sort(listen);
		System.out.println(listen);
		
		//2
		Collections.sort(listen, new AlfabetiskComparator());
		System.out.println(listen);
		
		//3
		Collections.sort(listen, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.toUpperCase().compareTo(s2.toUpperCase());
			}
		});
		System.out.println(listen);
		
		//4 Sortere alfabetisk med lambda utrykk
		Collections.sort(listen, (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()));
		System.out.println(listen);
		
		//5 Sorteres etter strenglengde
		Collections.sort(listen, (s1, s2) -> s1.length() - (s2.length()));
		System.out.println(listen);
		
		//6 Sortere baklengs på strenglengde
		Comparator<String> baklengsPaaLengde = (s1, s2) -> s2.length() - s1.length();
		Collections.sort(listen, baklengsPaaLengde);
		System.out.println(listen);
	}

}

class AlfabetiskComparator implements Comparator<String> {
	
	@Override
	public int compare(String s1, String s2) {
		return s1.toUpperCase().compareTo(s2.toUpperCase());
	}
	
}
