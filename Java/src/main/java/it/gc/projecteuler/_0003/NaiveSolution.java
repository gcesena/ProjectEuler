package it.gc.projecteuler._0003;

import it.gc.projecteuler.util.Pair;

import java.util.OptionalLong;

public class NaiveSolution implements Solution {
	@Override
	public OptionalLong apply(long number) {
		if (!Solution.isValid(number)) return OptionalLong.empty();

		var maxFactor = 1L;

		for (var i = 2L; number > 1; ) {
			var pair = factorizeOneStep(number, i);
			number = pair.right;
			maxFactor = pair.left;
			i = pair.left;
		}

		return OptionalLong.of(maxFactor);
	}

	private static Pair<Long, Long> factorizeOneStep(long number, long i) {
		for (; i < number; i++) {
			if (number % i == 0) {
				return Pair.of(i, number / i);
			}
		}
		return Pair.of(number, 1L);
	}
}
