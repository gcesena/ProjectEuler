package it.gc.projecteuler._0001;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class SolutionsTests {
	@Test
	void noDivisors() {
		// given
		var noDivisors = Set.<Integer>of();
		var limit = 10;

		// when
		var noDivisorsNaive = new NaiveSolution().apply(noDivisors, limit);
		var noDivisorsOptimal = new OptimalSolution().apply(noDivisors, limit);

		// then
		assertThat(noDivisorsNaive, is(OptionalInt.empty()));
		assertThat(noDivisorsOptimal, is(OptionalInt.empty()));
	}

	@Test
	void nonPositiveDivisors() {
		// given
		var negativeDivisor = Set.of(-1);
		var zeroDivisor = Set.of(0);
		var limit = 10;

		// when
		var negativeDivisorNaive = new NaiveSolution().apply(negativeDivisor, limit);
		var negativeDivisorOptimal = new OptimalSolution().apply(negativeDivisor, limit);
		var zeroDivisorNaive = new NaiveSolution().apply(zeroDivisor, limit);
		var zeroDivisorOptimal = new OptimalSolution().apply(zeroDivisor, limit);

		// then
		assertThat(negativeDivisorNaive, is(OptionalInt.empty()));
		assertThat(negativeDivisorOptimal, is(OptionalInt.empty()));
		assertThat(zeroDivisorNaive, is(OptionalInt.empty()));
		assertThat(zeroDivisorOptimal, is(OptionalInt.empty()));
	}

	@Test
	void nonPositiveLimit() {
		// given
		var divisors = Set.of(3, 5);
		var negativeLimit = -1;
		var zeroLimit = 0;

		// when
		var negativeLimitNaive = new NaiveSolution().apply(divisors, negativeLimit);
		var negativeLimitOptimal = new OptimalSolution().apply(divisors, negativeLimit);
		var zeroLimitNaive = new NaiveSolution().apply(divisors, zeroLimit);
		var zeroLimitOptimal = new OptimalSolution().apply(divisors, zeroLimit);

		// then
		assertThat(negativeLimitNaive, is(OptionalInt.empty()));
		assertThat(negativeLimitOptimal, is(OptionalInt.empty()));
		assertThat(zeroLimitNaive, is(OptionalInt.empty()));
		assertThat(zeroLimitOptimal, is(OptionalInt.empty()));
	}

	@Test
	void multiplesOf3And5Below10() {
		// given
		var divisors = Set.of(3, 5);
		var limit = 10;

		// when
		var naiveSolution = new NaiveSolution().apply(divisors, limit);
		var optimalSolution = new OptimalSolution().apply(divisors, limit);

		// then
		assertThat(naiveSolution, is(equalTo(OptionalInt.of(23))));
		assertThat(optimalSolution, is(equalTo(OptionalInt.of(23))));
	}
}
