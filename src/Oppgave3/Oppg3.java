package Oppgave3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Oppgave2.Ansatt;
import Oppgave2.Kjonn;

public class Oppg3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Troy", "Bryant", Kjonn.MANN, "Sjef", 500000),
				new Ansatt("Ellie", "Stewart", Kjonn.KVINNE, "Medarbeider", 400000),
				new Ansatt("Kim", "Farmer", Kjonn.ANNET, "Team Leader", 420000),
				new Ansatt("Charley", "Pratt", Kjonn.MANN, "Vikar", 350000));
		// a)
		List<String> etternavnene = ansatte.stream()
				.map(p -> p.getEtternavn())
				.collect(Collectors.toList());

		System.out.println("Etternavnene: " + etternavnene.toString());

		// b)
		long antallKvinner = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE)
				.count();

		System.out.println("Antall Kvinner: " + antallKvinner);

		// c)
		OptionalDouble avgKvinneLonn = ansatte.stream()
				.filter(a -> a.getKjonn().equals(Kjonn.KVINNE))
				.mapToDouble(x -> x.getAarslonn())
				.average();

		System.out.println("Gjennomsnittslønnen til kvinnene: " + avgKvinneLonn);

		// d)
		ansatte.stream()
				.filter(x -> x.getStilling().toLowerCase().contains("sjef"))
				.forEach(x -> x.setAarslonn((int) (x.getAarslonn() * 1.07)));

		System.out.println("7% lønnsøkning for sjefer: ");
		ansatte.stream()
				.forEach(System.out::println);

		// e)
		Boolean tjenerMerEnn = ansatte.stream()
				.anyMatch(x -> x.getAarslonn() > 800000);
		
		System.out.println("At noen tjener mer enn 800 000 er: " + tjenerMerEnn);

		// f)
		ansatte.stream()
				.forEach(System.out::println);

		// g)
		Ansatt lavesteLonn = ansatte.stream()
				.min(Comparator.comparing(x -> x.getAarslonn()))
				.get();

		System.out.println("Den ansatte med lavest lønn er: " + lavesteLonn.toString());

		// h)
		int heltallDeleligFemTre = (int) IntStream.range(1, 1000)
				.filter(x -> x % 3 == 0 || x % 5 == 0)
				.sum();

		System.out.println("Summen av alle heltall mellom 1 og 1000, delelig med 3 eller 5: " + heltallDeleligFemTre);
	}
}