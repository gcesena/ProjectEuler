package it.gc.projecteuler._0003;

import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SolutionsTests {
	private final Solution naiveAlgorithm = new NaiveSolution();
	private final Solution optimalAlgorithm = new OptimalSolution();

	@Test
	void nonPositiveNumber() {
		// given
		var negativeNumber = -1;
		var zeroNumber = 0;

		// when
		var negativeNumberNaive = naiveAlgorithm.apply(negativeNumber);
		var zeroNumberNaive = naiveAlgorithm.apply(zeroNumber);
		var negativeNumberOptimal = optimalAlgorithm.apply(negativeNumber);
		var zeroNumberOptimal = optimalAlgorithm.apply(zeroNumber);

		// then
		assertThat(negativeNumberNaive, is(OptionalLong.empty()));
		assertThat(zeroNumberNaive, is(OptionalLong.empty()));
		assertThat(negativeNumberOptimal, is(OptionalLong.empty()));
		assertThat(zeroNumberOptimal, is(OptionalLong.empty()));
	}

	@Test
	void positiveNumber() {
		// given
		var oneNumber = 1;
		var otherNumber = 13195;

		// when
		var oneNumberNaive = naiveAlgorithm.apply(oneNumber);
		var otherNumberNaive = naiveAlgorithm.apply(otherNumber);
		var oneNumberOptimal = optimalAlgorithm.apply(oneNumber);
		var otherNumberOptimal = optimalAlgorithm.apply(otherNumber);

		// then
		assertThat(oneNumberNaive, is(OptionalLong.of(1)));
		assertThat(otherNumberNaive, is(OptionalLong.of(29)));
		assertThat(oneNumberOptimal, is(OptionalLong.of(1)));
		assertThat(otherNumberOptimal, is(OptionalLong.of(29)));
	}
}
