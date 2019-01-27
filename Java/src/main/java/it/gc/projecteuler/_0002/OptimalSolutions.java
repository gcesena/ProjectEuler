package it.gc.projecteuler._0002;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Optimal solutions rely on the fact we're searching for even numbers: the very information carried by the _filter_.
 * Hence, it cannot implement {@link Solution} nor be tested in the same exact way
 */
public final class OptimalSolutions {
	private OptimalSolutions() {
	}

	public static OptionalInt hopping(IntPredicate takeWhile) {
		var sequence = FibonacciSequence.build();

		if (!Solution.isValid(sequence, takeWhile, i -> true)) return OptionalInt.empty();

		var fibonacciNumbers = sequence
				.takeWhile(takeWhile)
				.boxed()
				.collect(Collectors.toList());
		var sum = Stream
				.iterate(0, i -> i + 3)
				.takeWhile(i -> i < fibonacciNumbers.size())
				.map(fibonacciNumbers::get)
				.mapToInt(i -> i)
				.sum();
		return OptionalInt.of(sum);
	}

	public static OptionalInt evenSequence(IntPredicate takeWhile) {
		var evenSequence = EvenFibonacciSequence.build();

		if (!Solution.isValid(evenSequence, takeWhile, i -> true)) return OptionalInt.empty();

		var sum = evenSequence
				.takeWhile(takeWhile)
				.sum();
		return OptionalInt.of(sum);
	}
}
