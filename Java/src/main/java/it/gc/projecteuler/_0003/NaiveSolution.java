package it.gc.projecteuler._0003;

import it.gc.projecteuler.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

public class NaiveSolution implements Solution {
	@Override
	public OptionalLong apply(long number) {
		if (!Solution.isValid(number)) return OptionalLong.empty();

		var factors = new ArrayList<>(List.of(1L));

		for (var i = 2L; number > 1; ) {
			var pair = factorOneStep(number, i);
			number = pair.right;
			factors.add(pair.left);
			i = pair.left;
		}

		return factors
				.stream()
				.mapToLong(i -> i)
				.max();
	}

	private static Pair<Long, Long> factorOneStep(long number, long i) {
		for (; i < number; i++) {
			if (number % i == 0) {
				return Pair.of(i, number / i);
			}
		}
		return Pair.of(number, 1L);
	}
}
