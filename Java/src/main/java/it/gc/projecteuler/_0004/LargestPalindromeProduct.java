package it.gc.projecteuler._0004;

public class LargestPalindromeProduct {
	public static void main(String[] args) {
		var digits = 3;
		var radix = 10;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(digits, radix));
	}
}
