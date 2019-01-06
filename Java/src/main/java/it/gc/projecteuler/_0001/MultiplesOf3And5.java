package it.gc.projecteuler._0001;

public class MultiplesOf3And5 {
	public static void main(String[] args) {
		var divisors = new int[]{3, 5};
		var limit = 1000;
		var algorithm = SolutionFactory.naive();

		System.out.println(algorithm.run(divisors, limit));
	}
}
