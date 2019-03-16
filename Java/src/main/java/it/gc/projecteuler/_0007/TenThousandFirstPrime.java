package it.gc.projecteuler._0007;

public class TenThousandFirstPrime {
	public static void main(String[] args) {
		var index = 10_001;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(index));
	}
}
