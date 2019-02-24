package it.gc.projecteuler._0004;

import java.util.Optional;

public class NaiveSolution implements Solution {
	@Override
	public Optional<PalindromeProduct> apply(int digits, int radix) {
		if (!Solution.isValid(digits, radix)) return Optional.empty();

		var product = PalindromeProduct.of(radix, 0, 0, 0);

		var limit = (int) Math.pow(radix, digits) - 1;
		for (var i = limit; i > 0; i--) {
			for (var j = limit; i <= j; j--) {
				var result = i * j;

				if ((product.result < result) && isPalindrome(Integer.toString(result, radix))) {
					product = PalindromeProduct.of(radix, i, j, result);
				}
			}
		}

		return Optional.of(product);
	}

	private static boolean isPalindrome(String number) {
		for (var i = 0; i < number.length() / 2; i++) {
			char start = number.charAt(i);
			char end = number.charAt(number.length() - i - 1);

			if (start != end) {
				return false;
			}
		}
		return true;
	}
}
