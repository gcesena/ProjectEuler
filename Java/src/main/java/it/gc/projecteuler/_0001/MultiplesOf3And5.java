package it.gc.projecteuler._0001;

import java.util.Set;

public class MultiplesOf3And5 {
	public static void main(String[] args) {
		var divisors = Set.of(3, 5);
		var limit = 1000;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(divisors, limit));
	}
}
