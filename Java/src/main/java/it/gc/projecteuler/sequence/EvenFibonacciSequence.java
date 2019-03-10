package it.gc.projecteuler.sequence;

import it.gc.projecteuler.util.Pair;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class EvenFibonacciSequence {
	private EvenFibonacciSequence() {
	}

	public static IntStream build() {
		return Stream
				.iterate(Pair.of(2, 8), prev -> Pair.of(prev.right, prev.left + (4 * prev.right)))
				.mapToInt(pair -> pair.left);
	}
}
