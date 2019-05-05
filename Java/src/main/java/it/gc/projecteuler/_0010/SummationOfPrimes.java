package it.gc.projecteuler._0010;

public class SummationOfPrimes {
	public static void main(String[] args) {
		var limit = 2_000_000;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(limit));
	}
}
