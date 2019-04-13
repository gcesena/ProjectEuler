package it.gc.projecteuler._0006;

import java.util.OptionalDouble;

public interface Solution {
	OptionalDouble apply(int limit, double exponent);

	static boolean isValid(int limit, double exponent) {
		if (!(limit >= 0)) return false;

		// Every value of exponent is always valid

		return true;
	}
}
