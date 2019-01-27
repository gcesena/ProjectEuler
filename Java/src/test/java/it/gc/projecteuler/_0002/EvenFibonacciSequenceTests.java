package it.gc.projecteuler._0002;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class EvenFibonacciSequenceTests {
	@Test
	void first10EvenFibonacciNumbers() {
		// given
		var evenSequence = EvenFibonacciSequence.build();

		// when
		var evenFibonacciNumbers = evenSequence.limit(10).toArray();

		// then
		assertThat(evenFibonacciNumbers[0], is(equalTo(2)));
		assertThat(evenFibonacciNumbers[1], is(equalTo(8)));
		assertThat(evenFibonacciNumbers[2], is(equalTo(34)));
		assertThat(evenFibonacciNumbers[3], is(equalTo(144)));
		assertThat(evenFibonacciNumbers[4], is(equalTo(610)));
		assertThat(evenFibonacciNumbers[5], is(equalTo(2584)));
		assertThat(evenFibonacciNumbers[6], is(equalTo(10946)));
		assertThat(evenFibonacciNumbers[7], is(equalTo(46368)));
		assertThat(evenFibonacciNumbers[8], is(equalTo(196418)));
		assertThat(evenFibonacciNumbers[9], is(equalTo(832040)));
	}
}
