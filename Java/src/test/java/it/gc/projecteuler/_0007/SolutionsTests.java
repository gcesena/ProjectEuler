package it.gc.projecteuler._0007;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class SolutionsTests {
	private Solution naiveAlgorithm = new NaiveSolution();

	@Test
	void nonPositiveIndex() {
		// given
		var negativeIndex = -1;
		var zeroIndex = 0;

		// when
		var negativeIndexNaive = naiveAlgorithm.apply(negativeIndex);
		var zeroIndexNaive = naiveAlgorithm.apply(zeroIndex);

		// then
		assertThat(negativeIndexNaive, is(equalTo(OptionalInt.empty())));
		assertThat(zeroIndexNaive, is(equalTo(OptionalInt.empty())));
	}

	@Test
	void firstPrime() {
		// given
		var index = 1;

		// when
		var primeNaive = naiveAlgorithm.apply(index);

		// then
		assertThat(primeNaive, is(equalTo(OptionalInt.of(2))));
	}

	@Test
	void sixthPrime() {
		// given
		var index = 6;

		// when
		var primeNaive = naiveAlgorithm.apply(index);

		// then
		assertThat(primeNaive, is(equalTo(OptionalInt.of(13))));
	}
}
