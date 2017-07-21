/**
 * Interface for a pseudo RNG that generates integers.
 */
public interface IntegerRNG {
	public int[] output();

	public double ratio(int[] n);
}
