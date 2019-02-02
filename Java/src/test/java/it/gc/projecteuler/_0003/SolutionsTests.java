package it.gc.projecteuler._0003;

import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SolutionsTests {
	private final Solution naiveAlgorithm = new NaiveSolution();

	@Test
	void nonPositiveNumber() {
		// given
		var negativeNumber = -1;
		var zeroNumber = 0;

		// when
		var negativeNumberNaive = naiveAlgorithm.apply(negativeNumber);
		var zeroNumberNaive = naiveAlgorithm.apply(zeroNumber);

		// then
		assertThat(negativeNumberNaive, is(OptionalLong.empty()));
		assertThat(zeroNumberNaive, is(OptionalLong.empty()));
	}

	@Test
	void positiveNumber() {
		// given
		var oneNumber = 1;
		var otherNumber = 13195;

		// when
		var oneNumberNaive = naiveAlgorithm.apply(oneNumber);
		var otherNumberNaive = naiveAlgorithm.apply(otherNumber);

		// then
		assertThat(oneNumberNaive, is(OptionalLong.of(1)));
		assertThat(otherNumberNaive, is(OptionalLong.of(29)));
	}
}
