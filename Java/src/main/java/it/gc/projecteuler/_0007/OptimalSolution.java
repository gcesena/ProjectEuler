package it.gc.projecteuler._0007;

import it.gc.projecteuler.sequence.FastPrimeSequence;

import java.util.OptionalInt;

public class OptimalSolution implements Solution {
	@Override
	public OptionalInt apply(int index) {
		if (!Solution.isValid(index)) return OptionalInt.empty();

		return FastPrimeSequence
				.memoryIntensive()
				.skip(index - 1)
				.findFirst();
	}
}
