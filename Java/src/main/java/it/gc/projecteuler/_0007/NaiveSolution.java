package it.gc.projecteuler._0007;

import it.gc.projecteuler.sequence.PrimeSequence;

import java.util.OptionalInt;

public class NaiveSolution implements Solution {
	@Override
	public OptionalInt apply(int index) {
		if (!Solution.isValid(index)) return OptionalInt.empty();

		return PrimeSequence
				.memoryIntensive()
				.skip(index - 1)
				.findFirst();
	}
}
