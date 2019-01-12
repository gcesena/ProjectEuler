package it.gc.projecteuler._0001;

import java.util.OptionalInt;
import java.util.Set;

public interface Solution {
	OptionalInt apply(Set<Integer> divisors, int limit);
}
