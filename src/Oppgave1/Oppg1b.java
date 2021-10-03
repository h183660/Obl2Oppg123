package Oppgave1;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Oppg1b {

	public static void main(String[] args) {

		int i = beregn(12, 13, (a,b) -> a+b);
		int ii = beregn(-5, 3, (a,b) -> Math.max(a,b));
		int iii = beregn(54, 45, (a,b) -> Math.abs(a-b));
		
		System.out.println(i);
		System.out.println(ii);
		System.out.println(iii);

	}

	public static <T> int beregn(int a, int b, BiFunction<Integer, Integer, Integer> f) {
		return f.apply(a, b);		
	}
}