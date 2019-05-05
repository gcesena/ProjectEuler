package it.gc.projecteuler._0010;

import java.util.OptionalLong;

public interface Solution {
	OptionalLong apply(int limit);

	static boolean isValid(int limit) {
		// Every value of limit is always valid

		return true;
	}
}
