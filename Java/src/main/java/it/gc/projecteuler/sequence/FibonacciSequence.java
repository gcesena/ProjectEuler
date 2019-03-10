package it.gc.projecteuler.sequence;

import it.gc.projecteuler.util.Tuple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class FibonacciSequence {
	private FibonacciSequence() {
	}

	public static IntStream build() {
		return Stream
				.iterate(Tuple.of(0, 1), prev -> Tuple.of(prev.right, prev.left + prev.right))
				.mapToInt(tuple -> tuple.left);
	}
}
