package Oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Troy", "Bryant", Kjonn.MANN, "Sjef", 500000),
				new Ansatt("Ellie", "Stewart", Kjonn.KVINNE, "Medarbeider", 400000),
				new Ansatt("Kim", "Farmer", Kjonn.ANNET, "Team Leader", 420000),
				new Ansatt("Charley", "Pratt", Kjonn.MANN, "Vikar", 350000)
				);

		System.out.println("Uten justert lønn:");
		skrivUtAlle(ansatte);

		lonnsoppgjor(ansatte, (x) -> 500);
		System.out.println("+500");
		skrivUtAlle(ansatte);

		lonnsoppgjor(ansatte, (x) -> x.getAarslonn() / 10);
		System.out.println("+ 10 %");
		skrivUtAlle(ansatte);

		lonnsoppgjor(ansatte, (x) -> {
			if (x.getAarslonn() < 400000) {
				return 1000000;
			} else {
				return 0;
			}
		});
		System.out.println("+ 1 mil til alle som tjener under 400 k");
		skrivUtAlle(ansatte);

		lonnsoppgjor(ansatte, (x) -> {
			if (x.getKjonn().equals(Kjonn.MANN)) {
				return x.getAarslonn() / 10;
			} else {
				return 0;
			}
		});
		System.out.println("+ 10% om du e mann");
		skrivUtAlle(ansatte);
	}

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> f) {
		ansatte.stream().forEach(a -> a.setAarslonn(a.getAarslonn() + f.apply(a)));
	}

	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a.toString());
		}
	}
}