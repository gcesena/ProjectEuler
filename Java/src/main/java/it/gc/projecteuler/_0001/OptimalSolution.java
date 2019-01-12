package it.gc.projecteuler._0001;

import java.util.OptionalInt;
import java.util.Set;

import static it.gc.projecteuler._0001.Solution.isValid;

public class OptimalSolution implements Solution {
	@Override
	public OptionalInt apply(Set<Integer> divisors, int limit) {
		if (!isValid(divisors, limit)) return OptionalInt.empty();

		var sortedDivisors = divisors.stream().sorted().mapToInt(x -> x).toArray();
		return OptionalInt.of(apply(sortedDivisors, limit));
	}

	private static int apply(int[] divisors, int limit) {
		var sum = 0;

		for (var i = 0; i < divisors.length; i++) {
			sum += apply(divisors[i], limit);

			for (var j = i + 1; j < divisors.length; j++) {
				sum -= apply(divisors[i] * divisors[j], limit);
			}
		}

		return sum;
	}

	private static int apply(int divisor, int limit) {
		var p = (limit - 1) / divisor;
		return (divisor * p * (p + 1)) / 2;
	}
}
