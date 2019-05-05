package it.gc.projecteuler._0010;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("SummationOfPrimes")
class SolutionsTests {
	private Solution naiveAlgorithm = new NaiveSolution();

	@Test
	void summationOfPrimesBelow10() {
		// given
		var limit = 10;

		// when
		var sumNaive = naiveAlgorithm.apply(limit);

		// then
		assertThat(sumNaive, is(equalTo(OptionalLong.of(17))));
	}
}
