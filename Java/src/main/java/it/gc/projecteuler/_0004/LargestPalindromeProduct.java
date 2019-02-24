package it.gc.projecteuler._0004;

/*
 * Why this problem only has the naïve algorithm.
 *
 * Because the very last solution, as given in the overview paper, is very specific: not only for the radix it can be
 * used in (only 10), but also for the number of digits of the factors it can be run with (again, only 3).
 *
 * Any implementation would be parameter-less, accompanied by a single trivial test and programmatically non interesting
 */

public class LargestPalindromeProduct {
	public static void main(String[] args) {
		var digits = 3;
		var radix = 10;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(digits, radix));
	}
}
