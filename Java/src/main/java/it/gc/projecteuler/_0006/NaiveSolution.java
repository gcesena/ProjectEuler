package it.gc.projecteuler._0006;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class NaiveSolution implements Solution {
	@Override
	public OptionalDouble apply(int limit, double exponent) {
		if (!Solution.isValid(limit, exponent)) return OptionalDouble.empty();

		var sumOfSquares = IntStream
				.range(1, limit + 1)
				.mapToDouble(i -> Math.pow(i, exponent))
				.sum();
		var squareOfSum = Math.pow(IntStream.range(1, limit + 1).sum(), exponent);
		return OptionalDouble.of(squareOfSum - sumOfSquares);
	}
}
