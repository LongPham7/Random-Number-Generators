/**
 * Interface for a pseudo RNG that generates decimal numbers between 0 and 1.
 */
public interface DoubleRNG {
	public double[] output();

	public double ratio(double[] n);
}
