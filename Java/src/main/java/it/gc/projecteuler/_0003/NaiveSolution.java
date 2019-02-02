package it.gc.projecteuler._0003;

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
			factors.add(tuple.factor);
			number = tuple.newNumber;
		}

		return factors
				.stream()
				.mapToLong(i -> i)
				.max();
	}

	private static Tuple factorOneStep(long number) {
		for (var i = 2L; i < number; i++) {
			if (number % i == 0) {
				return Tuple.of(i, number / i);
			}
		}
		return Tuple.of(number, 1);
	}

	private static class Tuple {
		final long factor;
		final long newNumber;

		private Tuple(long factor, long newNumber) {
			this.factor = factor;
			this.newNumber = newNumber;
		}

		static Tuple of(long factor, long newNumber) {
			return new Tuple(factor, newNumber);
		}
	}
}
