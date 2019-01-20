package it.gc.projecteuler._0002;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class SolutionsTests {
	private final Solution naiveAlgorithm = new NaiveSolution();

	@Test
	void nullSequence() {
		// given
		var sequence = (IntStream) null;
		IntPredicate takeWhile = f -> f <= 100;
		IntPredicate filter = f -> f % 2 == 0;

		// when
		var nullSequenceNaive = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(nullSequenceNaive, is(OptionalInt.empty()));
	}

	@Test
	void emptySequence() {
		// given
		var sequence = IntStream.empty();
		IntPredicate takeWhile = f -> f <= 100;
		IntPredicate filter = f -> f % 2 == 0;

		// when
		var emptySequenceNaive = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(emptySequenceNaive, is(OptionalInt.of(0)));
	}

	@Test
	void nullTakeWhile() {
		// given
		var sequence = FibonacciSequence.build();
		IntPredicate takeWhile = null;
		IntPredicate filter = f -> f % 2 == 0;

		// when
		var nullTakeWhileNaive = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(nullTakeWhileNaive, is(OptionalInt.empty()));
	}

	@Test
	void falseTakeWhile() {
		// given
		var sequence = FibonacciSequence.build();
		IntPredicate takeWhile = f -> false;
		IntPredicate filter = f -> f % 2 == 0;

		// when
		var falseTakeWhileNaive = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(falseTakeWhileNaive, is(OptionalInt.of(0)));
	}

	@Test
	void nullFilter() {
		// given
		var sequence = FibonacciSequence.build();
		IntPredicate takeWhile = f -> f <= 100;
		IntPredicate filter = null;

		// when
		var nullFilterNaive = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(nullFilterNaive, is(OptionalInt.empty()));
	}

	@Test
	void falseFilter() {
		// given
		var sequence = FibonacciSequence.build();
		IntPredicate takeWhile = f -> f <= 100;
		IntPredicate filter = f -> false;

		// when
		var falseFilterNaive = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(falseFilterNaive, is(OptionalInt.of(0)));
	}

	@Test
	void evenFibonacciNumbersBelow100() {
		// given
		var sequence = FibonacciSequence.build();
		IntPredicate takeWhile = f -> f <= 100;
		IntPredicate filter = f -> f % 2 == 0;

		// when
		var naiveSolution = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(naiveSolution, is(equalTo(OptionalInt.of(44))));
	}

	@Test
	void oddFibonacciNumbersBelow100() {
		// given
		var sequence = FibonacciSequence.build();
		IntPredicate takeWhile = f -> f <= 100;
		IntPredicate filter = f -> f % 2 == 1;

		// when
		var naiveSolution = naiveAlgorithm.apply(sequence, takeWhile, filter);

		// then
		assertThat(naiveSolution, is(equalTo(OptionalInt.of(188))));
	}
}
