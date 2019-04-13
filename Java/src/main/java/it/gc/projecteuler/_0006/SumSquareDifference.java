package it.gc.projecteuler._0006;

public class SumSquareDifference {
	public static void main(String[] args) {
		var limit = 100;
		var exponent = 2;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(limit, exponent));
	}
}
