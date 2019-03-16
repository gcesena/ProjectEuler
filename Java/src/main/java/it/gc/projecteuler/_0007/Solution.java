package it.gc.projecteuler._0007;

import java.util.OptionalInt;

public interface Solution {
	OptionalInt apply(int index);

	static boolean isValid(int index) {
		if (!(index > 0)) return false;

		return true;
	}
}
