package it.gc.projecteuler._0001;

import java.util.OptionalInt;
import java.util.Set;

public class NaiveSolution implements Solution {
	@Override
	public OptionalInt apply(Set<Integer> divisors, int limit) {
		if (divisors.isEmpty()) return OptionalInt.empty();
		if (!(divisors.stream().allMatch(divisor -> divisor > 0))) return OptionalInt.empty();

		if (!(limit > 0)) return OptionalInt.empty();

		var sortedDivisors = divisors.stream().sorted().mapToInt(x -> x).toArray();
		return OptionalInt.of(apply(sortedDivisors, limit));
	}

	private static int apply(int[] divisors, int limit) {
		var sum = 0;

		for (var i = 1; i < limit; i++) {
			var found = false;

			for (var j = 0; (j < divisors.length) && !found; j++) {
				var divisor = divisors[j];

				if (i % divisor == 0) {
					sum += i;
					found = true;
				}
			}
		}

		return sum;
	}
}
