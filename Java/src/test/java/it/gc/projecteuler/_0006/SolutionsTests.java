package it.gc.projecteuler._0006;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("SumSquareDifference")
class SolutionsTests {
	private Solution naiveAlgorithm = new NaiveSolution();
	private OptimalSolution optimalAlgorithm = new OptimalSolution();

	@Test
	void negativeLimit() {
		// given
		var negativeLimit = -1;
		var exponent = 2;

		// when
		var negativeLimitNaive = naiveAlgorithm.apply(negativeLimit, exponent);
		var negativeLimitOptimal = optimalAlgorithm.apply(negativeLimit);

		// then
		assertThat(negativeLimitNaive, is(equalTo(OptionalDouble.empty())));
		assertThat(negativeLimitOptimal, is(equalTo(OptionalDouble.empty())));
	}

	@Test
	void zeroLimit() {
		// given
		var limit = 0;
		var exponent = 2;

		// when
		var differenceNaive = naiveAlgorithm.apply(limit, exponent);
		var differenceOptimal = optimalAlgorithm.apply(limit);

		// then
		assertThat(differenceNaive, is(equalTo(OptionalDouble.of(0))));
		assertThat(differenceOptimal, is(equalTo(OptionalDouble.of(0))));
	}

	@Test
	void oneExponent() {
		// given
		var limit = 10;
		var exponent = 1;

		// when
		var differenceNaive = naiveAlgorithm.apply(limit, exponent);

		// then
		assertThat(differenceNaive, is(equalTo(OptionalDouble.of(0))));
	}

	@Test
	void zeroExponent() {
		// given
		var limit = 10;
		var exponent = 0;

		// when
		var differenceNaive = naiveAlgorithm.apply(limit, exponent);

		// then
		assertThat(differenceNaive, is(equalTo(OptionalDouble.of(-9))));
	}

	@Test
	void sumSquareDifferenceOf1Through10() {
		// given
		var limit = 10;
		var exponent = 2;

		// when
		var differenceNaive = naiveAlgorithm.apply(limit, exponent);
		var differenceOptimal = optimalAlgorithm.apply(limit);

		// then
		assertThat(differenceNaive, is(equalTo(OptionalDouble.of(2640))));
		assertThat(differenceOptimal, is(equalTo(OptionalDouble.of(2640))));
	}
}
