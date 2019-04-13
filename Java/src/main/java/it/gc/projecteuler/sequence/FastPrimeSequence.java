package it.gc.projecteuler.sequence;

import it.gc.projecteuler.util.Pair;
import it.gc.projecteuler.util.Triple;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class FastPrimeSequence {
	private FastPrimeSequence() {
	}

	public static IntStream memoryIntensive() {
		var twoAndThree = IntStream.of(2, 3);
		var sixKPlusMinusOne = Stream
				.iterate(Triple.of(new TreeSet<>(Set.of(2, 3)), IntStream.empty(), 6), FastPrimeSequence::memoryIntensiveNext)
				.flatMapToInt(triple -> triple.middle);

		return IntStream.concat(twoAndThree, sixKPlusMinusOne);
	}

	private static Triple<TreeSet<Integer>, IntStream, Integer> memoryIntensiveNext(
			Triple<TreeSet<Integer>, IntStream, Integer> triple) {
		var primes = triple.left;
		var candidates = List.of(triple.right - 1, triple.right + 1);
		var results = new TreeSet<Integer>();

		for (var candidate : candidates) {
			var squareRoot = (int) Math.sqrt(candidate);
			if (primes.stream().filter(prime -> prime <= squareRoot).allMatch(prime -> candidate % prime != 0)) {
				results.add(candidate);
			}
		}
		primes.addAll(results);

		return Triple.of(primes, results.stream().mapToInt(i -> i), triple.right + 6);
	}

	public static IntStream processorIntensive() {
		var twoAndThree = IntStream.of(2, 3);
		var sixKPlusMinusOne = Stream
				.iterate(Pair.of(IntStream.empty(), 6), FastPrimeSequence::processorIntensiveNext)
				.flatMapToInt(pair -> pair.left);

		return IntStream.concat(twoAndThree, sixKPlusMinusOne);
	}

	private static Pair<IntStream, Integer> processorIntensiveNext(Pair<IntStream, Integer> pair) {
		var candidates = List.of(pair.right - 1, pair.right + 1);
		var results = new TreeSet<Integer>();

		for (var candidate : candidates) {
			var squareRoot = (int) Math.sqrt(candidate);
			if (IntStream.range(2, squareRoot + 1).allMatch(i -> candidate % i != 0)) {
				results.add(candidate);
			}
		}

		return Pair.of(results.stream().mapToInt(i -> i), pair.right + 6);
	}
}
