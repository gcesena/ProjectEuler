package it.gc.projecteuler._0005;

import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

public class NaiveSolution implements Solution {
	@Override
	public OptionalInt apply(int limit) {
		if (!Solution.isValid(limit)) return OptionalInt.empty();

		var divisors = minimumSetOfDivisorsOf1Through(limit);
		if (!divisors.isEmpty()) {
			for (var i = limit; true; i += limit) {
				final var candidate = i;
				if (divisors.stream().allMatch(divisor -> candidate % divisor == 0)) {
					return OptionalInt.of(candidate);
				}
			}
		} else {
			return OptionalInt.of(limit);
		}
	}

	/*
	 * We prefer large numbers with multiple factors, so to reduce to the bare minimum the number of modulo operations
	 * later on (e.g. being divisible by 20 also means to be divisible by 10, 5 and 2)
	 */
	private static Set<Integer> minimumSetOfDivisorsOf1Through(int limit) {
		var divisors = new HashSet<Integer>();

		// Divisibility by limit is enforced later on by using limit as the step length
		for (var i = limit - 1; i > 1; i--) {
			final var candidate = i;
			if (divisors.isEmpty() || divisors.stream().allMatch(divisor -> divisor % candidate != 0)) {
				divisors.add(candidate);
			}
		}

		return divisors;
	}
}
