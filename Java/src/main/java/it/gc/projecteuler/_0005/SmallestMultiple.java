package it.gc.projecteuler._0005;

public class SmallestMultiple {
	public static void main(String[] args) {
		var limit = 20;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(limit));
	}
}
