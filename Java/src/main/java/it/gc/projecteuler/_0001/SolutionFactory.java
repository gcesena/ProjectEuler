package it.gc.projecteuler._0001;

public final class SolutionFactory {
	private SolutionFactory() {
	}

	public static Solution naive() {
		return (divisors, limit) -> {
			var sum = 0;

			for (var i = 1; i < limit; i++) {
				var found = false;

				for (var j = 0; (j < divisors.length) && !found; j++) {
					var divisor = divisors[j];

					if (i % divisor == 0) {
						sum += i;
						found = true;
					}
				}
			}

			return sum;
		};
	}
}
