package it.gc.projecteuler._0006;

import java.util.OptionalDouble;

/**
 * Optimal solution rely on the fact we're searching for squares: the very information carried by the _exponent_.
 * Hence, it cannot implement {@link Solution} nor be tested in the same exact way
 */
public class OptimalSolution {
	public OptionalDouble apply(int limit) {
		var exponent = 2;

		if (!Solution.isValid(limit, exponent)) return OptionalDouble.empty();

		var sumOfSquares = (((2 * limit) + 1) * (limit + 1) * limit) / 6;
		var squareOfSum = Math.pow(limit * (limit + 1) / 2, exponent);
		return OptionalDouble.of(squareOfSum - sumOfSquares);
	}
}
