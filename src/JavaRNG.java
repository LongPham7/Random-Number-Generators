public class JavaRNG implements DoubleRNG {
	
	private int length;

	public JavaRNG(int length) {
		this.length = length;
	}

	/*
	 * This method creates a new array that stores elements produced by Java's
	 * pseudo RNG.
	 * 
	 * @return array that stores elements produced by Java's pseudo RNG
	 */
	public double[] output() {
		double[] result = new double[length];

		/*
		 * This loop inserts a random number with a range from 0.0 to 1.0 to each
		 * element in an array.
		 */
		for (int i = 0; i != length; i++) {
			result[i] = Math.random();
		}
		return result;
	}

	/*
	 * This method calculates the ratio of the number of points whose distance is
	 * less than or equal to the radius to the total number of points, and returns
	 * it.
	 * 
	 * @param n: array that stores decimal elements produced by a pseudo RNG radius:
	 * the value of radius
	 * 
	 * @return the result of unit-circle test
	 */
	public double ratio(double[] n) {
		int count = 0;

		/*
		 * This loop traverses the array, counting points whose distance is less than or
		 * equal to the radius
		 */
		for (int i = 0; i != n.length - 1; i++) {

			/*
			 * If the sum of squares of two consecutive terms is less than or equal to the
			 * square of radius, increment the local variable "count" by 1.
			 */
			if ((n[i] * n[i] + n[i + 1] * n[i + 1]) <= 1.0) {
				count++;
			}
		}
		return (double) count / (n.length - 1);
	}

}
