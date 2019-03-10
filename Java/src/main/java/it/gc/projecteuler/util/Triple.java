package it.gc.projecteuler.util;

public class Triple<L, M, R> {
	public final L left;
	public final M middle;
	public final R right;

	private Triple(L left, M middle, R right) {
		this.left = left;
		this.middle = middle;
		this.right = right;
	}

	public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right) {
		return new Triple<>(left, middle, right);
	}
}
