package it.gc.projecteuler._0010;

import it.gc.projecteuler.sequence.FastPrimeSequence;

import java.util.OptionalLong;

public class NaiveSolution implements Solution {
	@Override
	public OptionalLong apply(int limit) {
		if (!Solution.isValid(limit)) return OptionalLong.empty();

		var sum = FastPrimeSequence
				.processorIntensive()
				.takeWhile(prime -> prime < limit)
				.mapToLong(i -> i)
				.sum();
		return OptionalLong.of(sum);
	}
}
