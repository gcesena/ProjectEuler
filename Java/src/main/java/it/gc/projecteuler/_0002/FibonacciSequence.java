package it.gc.projecteuler._0002;

import it.gc.projecteuler.utils.Tuple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class FibonacciSequence {
	private FibonacciSequence() {
	}

	static IntStream build() {
		return Stream
				.iterate(Tuple.of(0, 1), prev -> Tuple.of(prev.right, prev.left + prev.right))
				.mapToInt(tuple -> tuple.left);
	}
}
