package it.gc.projecteuler._0005;

import it.gc.projecteuler.sequence.PrimeSequence;

import java.util.OptionalInt;

public class OptimalSolution implements Solution {
	@Override
	public OptionalInt apply(int limit) {
		if (!Solution.isValid(limit)) return OptionalInt.empty();

		var minMultiple = PrimeSequence
				.memoryIntensive()
				.takeWhile(prime -> prime <= limit)
				.reduce(1, (accumulator, prime) -> accumulator * factor(prime, limit));
		return OptionalInt.of(minMultiple);
	}

	private static int factor(int prime, int limit) {
		if (prime <= Math.sqrt(limit)) {
			var exponent = Math.floor(Math.log(limit) / Math.log(prime));
			return (int) Math.pow(prime, exponent);
		} else {
			return prime;
		}
	}
}
