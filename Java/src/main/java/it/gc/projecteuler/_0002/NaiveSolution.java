package it.gc.projecteuler._0002;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class NaiveSolution implements Solution {
	@Override
	public OptionalInt apply(IntStream sequence, IntPredicate takeWhile, IntPredicate filter) {
		if (!Solution.isValid(sequence, takeWhile, filter)) return OptionalInt.empty();

		var sum = sequence
				.takeWhile(takeWhile)
				.filter(filter)
				.sum();
		return OptionalInt.of(sum);
	}
}
