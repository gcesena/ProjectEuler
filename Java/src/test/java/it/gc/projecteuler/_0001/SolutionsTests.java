package it.gc.projecteuler._0001;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("MultiplesOf3And5")
class SolutionsTests {
	private final Solution naiveAlgorithm = new NaiveSolution();
	private final Solution optimalAlgorithm = new OptimalSolution();

	@Test
	void noDivisors() {
		// given
		var noDivisors = Set.<Integer>of();
		var limit = 10;

		// when
		var noDivisorsNaive = naiveAlgorithm.apply(noDivisors, limit);
		var noDivisorsOptimal = optimalAlgorithm.apply(noDivisors, limit);

		// then
		assertThat(noDivisorsNaive, is(equalTo(OptionalInt.empty())));
		assertThat(noDivisorsOptimal, is(equalTo(OptionalInt.empty())));
	}

	@Test
	void nonPositiveDivisors() {
		// given
		var negativeDivisor = Set.of(-1);
		var zeroDivisor = Set.of(0);
		var limit = 10;

		// when
		var negativeDivisorNaive = naiveAlgorithm.apply(negativeDivisor, limit);
		var negativeDivisorOptimal = optimalAlgorithm.apply(negativeDivisor, limit);
		var zeroDivisorNaive = naiveAlgorithm.apply(zeroDivisor, limit);
		var zeroDivisorOptimal = optimalAlgorithm.apply(zeroDivisor, limit);

		// then
		assertThat(negativeDivisorNaive, is(equalTo(OptionalInt.empty())));
		assertThat(negativeDivisorOptimal, is(equalTo(OptionalInt.empty())));
		assertThat(zeroDivisorNaive, is(equalTo(OptionalInt.empty())));
		assertThat(zeroDivisorOptimal, is(equalTo(OptionalInt.empty())));
	}

	@Test
	void nonPositiveLimit() {
		// given
		var divisors = Set.of(3, 5);
		var negativeLimit = -1;
		var zeroLimit = 0;

		// when
		var negativeLimitNaive = naiveAlgorithm.apply(divisors, negativeLimit);
		var negativeLimitOptimal = optimalAlgorithm.apply(divisors, negativeLimit);
		var zeroLimitNaive = naiveAlgorithm.apply(divisors, zeroLimit);
		var zeroLimitOptimal = optimalAlgorithm.apply(divisors, zeroLimit);

		// then
		assertThat(negativeLimitNaive, is(equalTo(OptionalInt.empty())));
		assertThat(negativeLimitOptimal, is(equalTo(OptionalInt.empty())));
		assertThat(zeroLimitNaive, is(equalTo(OptionalInt.empty())));
		assertThat(zeroLimitOptimal, is(equalTo(OptionalInt.empty())));
	}

	@Test
	void multiplesOf1Below1() {
		// given
		var divisors = Set.of(1);
		var limit = 1;

		// when
		var naiveSolution = naiveAlgorithm.apply(divisors, limit);
		var optimalSolution = optimalAlgorithm.apply(divisors, limit);

		// then
		assertThat(naiveSolution, is(equalTo(OptionalInt.of(0))));
		assertThat(optimalSolution, is(equalTo(OptionalInt.of(0))));
	}

	@Test
	void multiplesOf1Below2() {
		// given
		var divisors = Set.of(1);
		var limit = 2;

		// when
		var naiveSolution = naiveAlgorithm.apply(divisors, limit);
		var optimalSolution = optimalAlgorithm.apply(divisors, limit);

		// then
		assertThat(naiveSolution, is(equalTo(OptionalInt.of(1))));
		assertThat(optimalSolution, is(equalTo(OptionalInt.of(1))));
	}

	@Test
	void multiplesOf3And5Below10() {
		// given
		var divisors = Set.of(3, 5);
		var limit = 10;

		// when
		var naiveSolution = naiveAlgorithm.apply(divisors, limit);
		var optimalSolution = optimalAlgorithm.apply(divisors, limit);

		// then
		assertThat(naiveSolution, is(equalTo(OptionalInt.of(23))));
		assertThat(optimalSolution, is(equalTo(OptionalInt.of(23))));
	}
}
