package it.gc.projecteuler._0002;

import java.util.function.IntPredicate;

public class EvenFibonacciNumbers {
	public static void main(String[] args) {
		var sequence = FibonacciSequence.build();
		IntPredicate takeWhile = f -> f <= 4_000_000;
		IntPredicate filter = f -> f % 2 == 0;
		var algorithm = new NaiveSolution();

		System.out.println(algorithm.apply(sequence, takeWhile, filter));
	}
}
