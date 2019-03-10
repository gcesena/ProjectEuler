package it.gc.projecteuler._0005;

import it.gc.projecteuler.sequence.PrimeSequence;

import java.util.OptionalInt;
import java.util.stream.Collectors;

public class OptimalSolution implements Solution {
	@Override
	public OptionalInt apply(int limit) {
		if (!Solution.isValid(limit)) return OptionalInt.empty();

		var primes = PrimeSequence
				.memoryIntensive()
				.takeWhile(prime -> prime <= limit)
				.boxed()
				.collect(Collectors.toList());
		var limitLog = Math.log(limit);
		var result = 1;

		for (var prime : primes) {
			if (prime <= Math.sqrt(limit)) {
				var exponent = Math.floor(limitLog / Math.log(prime));
				result *= Math.pow(prime, exponent);
			} else {
				result *= prime;
			}
		}

		return OptionalInt.of(result);
	}
}
