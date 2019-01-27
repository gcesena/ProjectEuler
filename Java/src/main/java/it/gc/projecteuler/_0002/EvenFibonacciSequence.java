package it.gc.projecteuler._0002;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class EvenFibonacciSequence {
	private EvenFibonacciSequence() {
	}

	static IntStream build() {
		return Stream
				.iterate(Tuple.of(2, 8), prev -> Tuple.of(prev.f1, prev.f0 + (4 * prev.f1)))
				.mapToInt(tuple -> tuple.f0);
	}

	private static class Tuple {
		final int f0;
		final int f1;

		private Tuple(int f0, int f1) {
			this.f0 = f0;
			this.f1 = f1;
		}

		static Tuple of(int f0, int f1) {
			return new Tuple(f0, f1);
		}
	}
}
