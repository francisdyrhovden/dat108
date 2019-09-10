package no.hvl.dat108.Oppg2;

import java.util.function.BiFunction;

public class Oppg2b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiFunction<Integer, Integer, Integer> summer = (x, y) -> x + y;
		BiFunction<Integer, Integer, Integer> storst = (x, y) -> Math.max(x, y);
		BiFunction<Integer, Integer, Integer> absDiff = (x, y) -> Math.abs(x-y);
		
		System.out.println(beregn(12, 13, summer));
		System.out.println(beregn(-5, 3, storst));
		System.out.println(beregn(54, 45, absDiff));
		
	}
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> bi) {
		return bi.apply(a, b);
	}

}
