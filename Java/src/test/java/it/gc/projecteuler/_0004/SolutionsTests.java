package it.gc.projecteuler._0004;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class SolutionsTests {
	private Solution naiveAlgorithm = new NaiveSolution();

	@Test
	void nonPositiveDigits() {
		// given
		var negativeDigits = -1;
		var zeroDigits = 0;
		var radix = 10;

		// when
		var negativeDigitsNaive = naiveAlgorithm.apply(negativeDigits, radix);
		var zeroDigitsNaive = naiveAlgorithm.apply(zeroDigits, radix);

		// then
		assertThat(negativeDigitsNaive, is(equalTo(Optional.empty())));
		assertThat(zeroDigitsNaive, is(equalTo(Optional.empty())));
	}

	@Test
	void nonMinimumRadix() {
		// given
		var digits = 2;
		var negativeRadix = -1;
		var zeroRadix = 0;
		var oneRadix = 1;

		// when
		var negativeRadixNaive = naiveAlgorithm.apply(digits, negativeRadix);
		var zeroRadixNaive = naiveAlgorithm.apply(digits, zeroRadix);
		var oneRadixNaive = naiveAlgorithm.apply(digits, oneRadix);

		// then
		assertThat(negativeRadixNaive, is(equalTo(Optional.empty())));
		assertThat(zeroRadixNaive, is(equalTo(Optional.empty())));
		assertThat(oneRadixNaive, is(equalTo(Optional.empty())));
	}

	@Test
	void largestPalindromeProductOfTwoTwoDigitsNumbers() {
		// given
		var digits = 2;
		var radix = 10;

		// when
		var productNaive = naiveAlgorithm.apply(digits, radix);

		// then
		assertThat(productNaive.get().radix, is(equalTo(10)));
		assertThat(productNaive.get().multiplier, is(equalTo(91)));
		assertThat(productNaive.get().multiplicand, is(equalTo(99)));
		assertThat(productNaive.get().result, is(equalTo(9009)));
	}
}
