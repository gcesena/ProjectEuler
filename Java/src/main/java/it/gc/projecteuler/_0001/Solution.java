package it.gc.projecteuler._0001;

import java.util.OptionalInt;
import java.util.Set;

public interface Solution {
	OptionalInt apply(Set<Integer> divisors, int limit);

	static boolean isValid(Set<Integer> divisors, int limit) {
		if (divisors.isEmpty()) return false;
		if (!(divisors.stream().allMatch(divisor -> divisor > 0))) return false;

		if (!(limit > 0)) return false;

		return true;
	}
}
