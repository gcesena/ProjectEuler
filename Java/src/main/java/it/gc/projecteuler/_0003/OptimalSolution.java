package it.gc.projecteuler._0003;

import it.gc.projecteuler.utils.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

public class OptimalSolution implements Solution {
	@Override
	public OptionalLong apply(long number) {
		if (!Solution.isValid(number)) return OptionalLong.empty();

		var factors = new ArrayList<>(List.of(1L));

		while (isEven(number)) {
			number = divideByTwo(number);
			factors.add(2L);
		}

		for (var i = 3L; number > 1; ) {
			var tuple = factorOneStep(number, i);
			number = tuple.right;
			factors.add(tuple.left);
			i = tuple.left;
		}

		return factors
				.stream()
				.mapToLong(i -> i)
				.max();
	}

	private static boolean isEven(long number) {
		return (number & 0x1) == 0;
	}

	private static long divideByTwo(long number) {
		return number >> 1;
	}

	private static Tuple<Long, Long> factorOneStep(long number, long i) {
		for (var squareRoot = (long) Math.sqrt(number); i <= squareRoot; i++) {
			if (number % i == 0) {
				return Tuple.of(i, number / i);
			}
		}
		return Tuple.of(number, 1L);
	}
}
