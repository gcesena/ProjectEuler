package it.gc.projecteuler._0003;

import it.gc.projecteuler.utils.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

public class NaiveSolution implements Solution {
	@Override
	public OptionalLong apply(long number) {
		if (!Solution.isValid(number)) return OptionalLong.empty();

		var factors = new ArrayList<>(List.of(1L));

		while (number > 1) {
			var tuple = factorOneStep(number);
			factors.add(tuple.left);
			number = tuple.right;
		}

		return factors
				.stream()
				.mapToLong(i -> i)
				.max();
	}

	private static Tuple<Long, Long> factorOneStep(long number) {
		for (var i = 2L; i < number; i++) {
			if (number % i == 0) {
				return Tuple.of(i, number / i);
			}
		}
		return Tuple.of(number, 1L);
	}
}
