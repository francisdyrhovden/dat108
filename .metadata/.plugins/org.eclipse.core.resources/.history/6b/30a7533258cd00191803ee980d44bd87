
public class TestSelv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		betingetUtskrift("hallo", b -> b.length() > 4);
		betingetUtskrift("Francis", b -> b.startsWith("F"));
	}

	
	public static void betingetUtskrift(String s, StringBetingelse b) {
		if (b.erOppfylt(s)) {
			System.out.println(s);
		}
	}
}

@FunctionalInterface
interface StringBetingelse{
	boolean erOppfylt(String s);
}