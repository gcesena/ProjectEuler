package it.gc.projecteuler._0002;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class FibonacciSequenceTests {
	@Test
	void first10FibonacciNumbers() {
		// given
		var sequence = FibonacciSequence.build();

		// when
		var fibonacciNumbers = sequence.limit(10).toArray();

		// then
		assertThat(fibonacciNumbers[0], is(equalTo(0)));
		assertThat(fibonacciNumbers[1], is(equalTo(1)));
		assertThat(fibonacciNumbers[2], is(equalTo(1)));
		assertThat(fibonacciNumbers[3], is(equalTo(2)));
		assertThat(fibonacciNumbers[4], is(equalTo(3)));
		assertThat(fibonacciNumbers[5], is(equalTo(5)));
		assertThat(fibonacciNumbers[6], is(equalTo(8)));
		assertThat(fibonacciNumbers[7], is(equalTo(13)));
		assertThat(fibonacciNumbers[8], is(equalTo(21)));
		assertThat(fibonacciNumbers[9], is(equalTo(34)));
	}
}
