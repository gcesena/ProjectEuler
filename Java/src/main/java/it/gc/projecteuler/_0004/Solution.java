package it.gc.projecteuler._0004;

import java.util.Optional;

public interface Solution {
	Optional<PalindromeProduct> apply(int digits, int radix);

	static boolean isValid(int digits, int radix) {
		if (!(digits > 0)) return false;

		if (!(radix > 1)) return false;

		return true;
	}

	class PalindromeProduct {
		final int radix;
		final int multiplier;
		final int multiplicand;
		final int result;

		private PalindromeProduct(int radix, int multiplier, int multiplicand, int result) {
			this.radix = radix;
			this.multiplier = multiplier;
			this.multiplicand = multiplicand;
			this.result = result;
		}

		public static PalindromeProduct of(int radix, int multiplier, int multiplicand, int result) {
			return new PalindromeProduct(radix, multiplier, multiplicand, result);
		}

		@Override
		public String toString() {
			return "radix: [" + radix + "]"
					+ " multiplier: [" + multiplier + "]"
					+ " multiplicand: [" + multiplicand + "]"
					+ " result: [" + result + "]";
		}
	}
}
