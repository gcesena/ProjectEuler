package it.gc.projecteuler._0003;

import it.gc.projecteuler.util.Pair;

import java.util.OptionalLong;

public class OptimalSolution implements Solution {
	@Override
	public OptionalLong apply(long number) {
		if (!Solution.isValid(number)) return OptionalLong.empty();

		var maxFactor = 1L;

		while (isEven(number)) {
			number = divideByTwo(number);
			maxFactor = 2L;
		}

		for (var i = 3L; number > 1; ) {
			var pair = factorizeOneStep(number, i);
			number = pair.right;
			maxFactor = pair.left;
			i = pair.left;
		}

		return OptionalLong.of(maxFactor);
	}

	private static boolean isEven(long number) {
		return (number & 0x1) == 0;
	}

	private static long divideByTwo(long number) {
		return number >> 1;
	}

	private static Pair<Long, Long> factorizeOneStep(long number, long i) {
		for (var squareRoot = (long) Math.sqrt(number); i <= squareRoot; i++) {
			if (number % i == 0) {
				return Pair.of(i, number / i);
			}
		}
		return Pair.of(number, 1L);
	}
}
