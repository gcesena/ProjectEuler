package it.gc.projecteuler._0005;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class SolutionsTests {
	private NaiveSolution naiveAlgorithm = new NaiveSolution();

	@Test
	void nonPositiveLimit() {
		// given
		var negativeLimit = -1;
		var zeroLimit = 0;

		// when
		var negativeLimitNaive = naiveAlgorithm.apply(negativeLimit);
		var zeroLimitNaive = naiveAlgorithm.apply(zeroLimit);

		// then
		assertThat(negativeLimitNaive, is(equalTo(OptionalInt.empty())));
		assertThat(zeroLimitNaive, is(equalTo(OptionalInt.empty())));
	}

	@Test
	void smallestMultipleOf1() {
		// given
		var limit = 1;

		// when
		var multipleNaive = naiveAlgorithm.apply(limit);

		// then
		assertThat(multipleNaive, is(equalTo(OptionalInt.of(1))));
	}

	@Test
	void smallestMultipleOf1Through2() {
		// given
		var limit = 2;

		// when
		var multipleNaive = naiveAlgorithm.apply(limit);

		// then
		assertThat(multipleNaive, is(equalTo(OptionalInt.of(2))));
	}

	@Test
	void smallestMultipleOf1Through10() {
		// given
		var limit = 10;

		// when
		var multipleNaive = naiveAlgorithm.apply(limit);

		// then
		assertThat(multipleNaive, is(equalTo(OptionalInt.of(2520))));
	}
}
