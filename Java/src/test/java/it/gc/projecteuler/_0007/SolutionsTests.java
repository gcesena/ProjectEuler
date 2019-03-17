package it.gc.projecteuler._0007;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("TenThousandFirstPrime")
class SolutionsTests {
	private Solution naiveAlgorithm = new NaiveSolution();
	private Solution optimalAlgorithm = new OptimalSolution();

	@Test
	void nonPositiveIndex() {
		// given
		var negativeIndex = -1;
		var zeroIndex = 0;

		// when
		var negativeIndexNaive = naiveAlgorithm.apply(negativeIndex);
		var negativeIndexOptimal = optimalAlgorithm.apply(negativeIndex);
		var zeroIndexNaive = naiveAlgorithm.apply(zeroIndex);
		var zeroIndexOptimal = optimalAlgorithm.apply(zeroIndex);

		// then
		assertThat(negativeIndexNaive, is(equalTo(OptionalInt.empty())));
		assertThat(negativeIndexOptimal, is(equalTo(OptionalInt.empty())));
		assertThat(zeroIndexNaive, is(equalTo(OptionalInt.empty())));
		assertThat(zeroIndexOptimal, is(equalTo(OptionalInt.empty())));
	}

	@Test
	void firstPrime() {
		// given
		var index = 1;

		// when
		var primeNaive = naiveAlgorithm.apply(index);
		var primeOptimal = optimalAlgorithm.apply(index);

		// then
		assertThat(primeNaive, is(equalTo(OptionalInt.of(2))));
		assertThat(primeOptimal, is(equalTo(OptionalInt.of(2))));
	}

	@Test
	void sixthPrime() {
		// given
		var index = 6;

		// when
		var primeNaive = naiveAlgorithm.apply(index);
		var primeOptimal = naiveAlgorithm.apply(index);

		// then
		assertThat(primeNaive, is(equalTo(OptionalInt.of(13))));
		assertThat(primeOptimal, is(equalTo(OptionalInt.of(13))));
	}
}
