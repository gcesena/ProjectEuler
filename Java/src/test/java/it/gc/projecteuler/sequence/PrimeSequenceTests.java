package it.gc.projecteuler.sequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class PrimeSequenceTests {
	@Test
	void first10MemoryIntensivePrimeNumbers() {
		// given
		var sequence = PrimeSequence.memoryIntensive();

		// when
		var primeNumbers = sequence.limit(10).toArray();

		// then
		assertThat(primeNumbers[0], is(equalTo(2)));
		assertThat(primeNumbers[1], is(equalTo(3)));
		assertThat(primeNumbers[2], is(equalTo(5)));
		assertThat(primeNumbers[3], is(equalTo(7)));
		assertThat(primeNumbers[4], is(equalTo(11)));
		assertThat(primeNumbers[5], is(equalTo(13)));
		assertThat(primeNumbers[6], is(equalTo(17)));
		assertThat(primeNumbers[7], is(equalTo(19)));
		assertThat(primeNumbers[8], is(equalTo(23)));
		assertThat(primeNumbers[9], is(equalTo(29)));
	}

	@Test
	void first10ProcessorIntensivePrimeNumbers() {
		// given
		var sequence = PrimeSequence.processorIntensive();

		// when
		var primeNumbers = sequence.limit(10).toArray();

		// then
		assertThat(primeNumbers[0], is(equalTo(2)));
		assertThat(primeNumbers[1], is(equalTo(3)));
		assertThat(primeNumbers[2], is(equalTo(5)));
		assertThat(primeNumbers[3], is(equalTo(7)));
		assertThat(primeNumbers[4], is(equalTo(11)));
		assertThat(primeNumbers[5], is(equalTo(13)));
		assertThat(primeNumbers[6], is(equalTo(17)));
		assertThat(primeNumbers[7], is(equalTo(19)));
		assertThat(primeNumbers[8], is(equalTo(23)));
		assertThat(primeNumbers[9], is(equalTo(29)));
	}
}
