package it.gc.projecteuler.sequence;

import it.gc.projecteuler.util.Pair;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class FibonacciSequence {
	private FibonacciSequence() {
	}

	public static IntStream build() {
		return Stream
				.iterate(Pair.of(0, 1), prev -> Pair.of(prev.right, prev.left + prev.right))
				.mapToInt(pair -> pair.left);
	}
}
