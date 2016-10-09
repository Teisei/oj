public class Solution {
    /**

	Problem:
	Given an integers array A.
	Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1],
	calculate B WITHOUT divide operation.

	Idea:
	1) cache:
	compute productLeft[i] = A[0]*..*A[i]
	compute productRight[j] = A[j]*..*A[n-1]
	B = [productLeft[i-1] * productRight[i+1] for i in (0, n-1)]


     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
		ArrayList<Long> B = new ArrayList();
		if(A == null || A.size() == 0) return B;

		int n = A.size();
		long[] productLeft = new long[n];
		long[] productRight = new long[n];
		for(int i = 0; i < n; i ++){
			int j = n - 1 - i;
			productLeft[i] = (long)A.get(i);
			if(i > 0) productLeft[i] *= productLeft[i-1];
			productRight[j] = (long)A.get(j);
			if(j < n - 1) productRight[j] *= productRight[j+1];
		}

		for(int i = 0; i < n; i ++){
			long x = 1;
			if(i > 0) x *= productLeft[i-1];
			if(i < n - 1) x *= productRight[i+1];
			B.add(x);
		}
		return B;
    }
}
