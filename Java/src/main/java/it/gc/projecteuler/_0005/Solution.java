package it.gc.projecteuler._0005;

import java.util.OptionalInt;

public interface Solution {
	OptionalInt apply(int limit);

	static boolean isValid(int limit) {
		if (!(limit > 0)) return false;

		return true;
	}
}
