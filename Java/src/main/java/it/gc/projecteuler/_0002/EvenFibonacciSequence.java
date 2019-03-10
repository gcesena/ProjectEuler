package it.gc.projecteuler._0002;

import it.gc.projecteuler.util.Tuple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class EvenFibonacciSequence {
	private EvenFibonacciSequence() {
	}

	static IntStream build() {
		return Stream
				.iterate(Tuple.of(2, 8), prev -> Tuple.of(prev.right, prev.left + (4 * prev.right)))
				.mapToInt(tuple -> tuple.left);
	}
}
