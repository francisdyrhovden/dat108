import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> listen = Arrays.asList(-4, 9, 2, 7, 6, 0);
		List<Integer> filtrertListe;
		
//		//1
//		filtrertListe = filter(listen, new PartallBetingelse());
//		System.out.println(filtrertListe);
//		
//		//2
//		filtrertListe = filter(listen, x -> x % 2 == 0);
//		System.out.println(filtrertListe);
//		
//		//3
//		filtrertListe = filter(listen, x -> x > 0);
//		System.out.println(filtrertListe);
		
		//4
		filtrertListe = filter(listen, storreEnn(5));
		System.out.println(filtrertListe);
	}
	
	public static Betingelse storreEnn(int grense) {
		return x -> x > grense;
	}
	
	public static List<Integer> filter(List<Integer> liste, Betingelse b){
		
		List<Integer> resultat = new ArrayList<>();
		for (int tall : liste) {
			if (b.erOppfylt(tall)) {
				resultat.add(tall);
			}
		}
		return resultat;
	}

}

@FunctionalInterface
interface Betingelse{
	boolean erOppfylt(int tall);
}

class PartallBetingelse implements Betingelse{
	
	@Override
	public boolean erOppfylt(int tall) {
		return tall%2 == 0;
	}
	
}
