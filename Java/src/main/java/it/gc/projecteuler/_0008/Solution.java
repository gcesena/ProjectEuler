package it.gc.projecteuler._0008;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Solution {
	Optional<ProductInASeries> apply(BigInteger number, int windowLength);

	static boolean isValid(BigInteger number, int windowLength) {
		if (number == null) return false;

		if (!(windowLength >= 0)) return false;

		return true;
	}

	class ProductInASeries {
		final List<Integer> adjacentDigits;
		final long result;

		private ProductInASeries(List<Integer> adjacentDigits, long result) {
			this.adjacentDigits = new ArrayList<>(adjacentDigits);
			this.result = result;
		}

		public static ProductInASeries of(List<Integer> adjacentDigits, long result) {
			return new ProductInASeries(adjacentDigits, result);
		}

		@Override
		public String toString() {
			var adjacentDigits = this.adjacentDigits
					.stream()
					.map(Objects::toString)
					.collect(Collectors.joining(", "));
			return "adjacentDigits: [" + adjacentDigits + "]"
					+ " result: [" + result + "]";
		}
	}
}
