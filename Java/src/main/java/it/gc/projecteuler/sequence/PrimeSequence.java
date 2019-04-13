package it.gc.projecteuler.sequence;

import it.gc.projecteuler.util.Pair;
import it.gc.projecteuler.util.Triple;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class PrimeSequence {
	private PrimeSequence() {
	}

	public static IntStream memoryIntensive() {
		return Stream
				.iterate(Triple.of(new TreeSet<>(Set.of(2)), 2, 3), PrimeSequence::memoryIntensiveNext)
				.mapToInt(triple -> triple.middle);
	}

	private static Triple<TreeSet<Integer>, Integer, Integer> memoryIntensiveNext(
			Triple<TreeSet<Integer>, Integer, Integer> triple) {
		var primes = triple.left;
		for (var i = triple.right; true; i++) {
			final var candidate = i;
			if (primes.stream().allMatch(prime -> candidate % prime != 0)) {
				primes.add(candidate);

				return Triple.of(primes, candidate, candidate + 1);
			}
		}
	}

	public static IntStream processorIntensive() {
		return Stream
				.iterate(Pair.of(2, 3), PrimeSequence::processorIntensiveNext)
				.mapToInt(pair -> pair.left);
	}

	private static Pair<Integer, Integer> processorIntensiveNext(Pair<Integer, Integer> pair) {
		for (var i = pair.right; true; i++) {
			final var candidate = i;
			if (IntStream.range(2, candidate).allMatch(divisor -> candidate % divisor != 0)) {
				return Pair.of(candidate, candidate + 1);
			}
		}
	}
}
