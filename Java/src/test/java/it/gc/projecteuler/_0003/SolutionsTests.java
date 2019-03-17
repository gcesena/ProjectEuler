package it.gc.projecteuler._0003;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("LargestPrimeFactor")
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
		assertThat(negativeNumberNaive, is(equalTo(OptionalLong.empty())));
		assertThat(zeroNumberNaive, is(equalTo(OptionalLong.empty())));
		assertThat(negativeNumberOptimal, is(equalTo(OptionalLong.empty())));
		assertThat(zeroNumberOptimal, is(equalTo(OptionalLong.empty())));
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
		assertThat(oneNumberNaive, is(equalTo(OptionalLong.of(1))));
		assertThat(otherNumberNaive, is(equalTo(OptionalLong.of(29))));
		assertThat(oneNumberOptimal, is(equalTo(OptionalLong.of(1))));
		assertThat(otherNumberOptimal, is(equalTo(OptionalLong.of(29))));
	}
}
