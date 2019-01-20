package it.gc.projecteuler._0002;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface Solution {
	OptionalInt apply(IntStream sequence, IntPredicate takeWhile, IntPredicate filter);

	static boolean isValid(IntStream sequence, IntPredicate takeWhile, IntPredicate filter) {
		if (sequence == null) return false;

		if (takeWhile == null) return false;

		if (filter == null) return false;

		return true;
	}
}
