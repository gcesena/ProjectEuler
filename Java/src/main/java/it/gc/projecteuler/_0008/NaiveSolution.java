package it.gc.projecteuler._0008;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Another, hypothetical, way of solving this problem would be by replacing multiplications with additions; provided
 * that we:
 * <li> exclude all _adjacentDigits_ containing zeros; and
 * <li> filter out all ones before doing the sums
 * The number produced would be proportionate to the real result and only {@code _windowLength_ - 1} multiplications
 * would be needed.
 *
 * However, that algorithm will have most likely performed worse on a real processor: it would have meant to include two
 * conditional jumps.
 * Two very costly conditional jumps, given that the input _number_ is random-produced and no good jumping predictions
 * would have stalled the pipeline every other cycle
 */
public class NaiveSolution implements Solution {
	@Override
	public Optional<ProductInASeries> apply(BigInteger number, int windowLength) {
		if (!Solution.isValid(number, windowLength)) return Optional.empty();

		var product = ProductInASeries.of(Collections.emptyList(), 0);

		var digits = Arrays
				.stream(number.toString().split(""))
				.mapToInt(Integer::valueOf)
				.boxed()
				.collect(Collectors.toList());

		var exit = false;
		for (var i = 0; !exit; i++) {
			var adjacentDigits = digits
					.stream()
					.skip(i)
					.limit(windowLength)
					.collect(Collectors.toList());

			if (adjacentDigits.size() == windowLength) {
				var candidate = adjacentDigits
						.stream()
						.mapToLong(digit -> digit)
						.reduce(1, (accumulator, multiplicand) -> accumulator * multiplicand);

				if (candidate > product.result) {
					product = ProductInASeries.of(adjacentDigits, candidate);
				}
			} else {
				exit = true;
			}
		}

		return Optional.of(product);
	}
}
