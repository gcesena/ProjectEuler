package it.gc.projecteuler._0003;

public class LargestPrimeFactor {
	public static void main(String[] args) {
		var number = 600_851_475_143L;
		var algorithm = new OptimalSolution();

		System.out.println(algorithm.apply(number));
	}
}
