public class LehmerRNG 
{
	private int length;
	private int seed;
	private int m;
	private int a;
	private int c;
	
	public LehmerRNG(int k, int s, int coefficient1, int coefficient2, int coefficient3)
	{
		length = k;
		seed = s;
		m = coefficient1;
		a = coefficient2;
		c = coefficient3;
	}
	
	public int[] output()
	{
		int[] result = new int[length];
		result[0] = seed;
		
    	/*
    	 * This loop calculates elements using the preceding elements based on the formula
    	 * of Lehmer's pseudo RNG. 
    	 */
    	for(int i=0;i<length;i++)
    	{
    		/*The first element is derived from the seed given by the user.*/
    		if(i==0)
    		{
    			result[0] = (a*seed+c)%m;
    		}
    		
    		/*The other elements are derived from the preceding elements.*/
    		else
    		{
    			result[i] = (a*result[i-1]+c)%m;
    		}
    	}
		return result;
	}
	
	/*
     * This method calculates the ratio of the number of points whose distance is
     * less than or equal to the radius to the total number of points, and returns it.
     * @param   n:        array that stores integral elements produced by a pseudo RNG
     *          radius:   the value of radius
     * @return  the result of unit-circle test
     */
    public double ratio(int[] n)
    {
    	int count = 0;
    	double first;
    	double second;
    	/*
    	 * This loop traverses the array of input, counting points whose distance is
    	 * less than or equal to the radius.
    	 */
    	for(int i=0;i<n.length-1;i++)
    	{
    		
    		/*
    		 * If the sum of squares of two consecutive terms is less than or equal
    		 * to the square of radius, increment the local variable "count" by 1.
    		 */
    		first = (double)n[i]/m;
    		second = (double)n[i+1]/m;
    		
    		if(first*first+second*second<=1)
    		{
    			count++;
    		}
    	}
    	return (double)count/(n.length-1);
    }
}
