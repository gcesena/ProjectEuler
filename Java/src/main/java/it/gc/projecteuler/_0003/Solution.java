package it.gc.projecteuler._0003;

import java.util.OptionalLong;

public interface Solution {
	OptionalLong apply(long number);

	static boolean isValid(long number) {
		if (!(number > 0)) return false;

		return true;
	}
}
