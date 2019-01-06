package it.gc.projecteuler._0001;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SolutionFactoryTest {
	@Test
	public void testMultiplesOf3And5Below10() {
		var divisors = new int[]{3, 5};
		var limit = 10;

		var naive = SolutionFactory.naive();
		assertThat(naive.run(divisors, limit), is(equalTo(23)));
	}
}
