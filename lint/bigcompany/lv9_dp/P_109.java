public class P_109 {
	/**
	 * Problem:
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	 *
	 *
	 * @param triangle: a list of lists of integers.
	 * @return: An integer, minimum path sum.
	 *
	 * Constraints:
	 * 1) trangle: n levels, 0<= n
	 * 2) there are i numbers in ith level
	 * 3) num[i][j] means the j th number in the i th level
	 * 4) num[i][j] can go to num[i+1][j] and num[i+1][j+1]
	 * 5) path sum: sum of all nodes'val of a top-down path
	 * 6) OUTPUT: return the minimum sum
	 *
	 *
	 * Idea:
	 * 1) compute the sum for each path
	 * time: O(2^(n-1))
	 * space: O(1)
	 *
	 * 2)
	 * just keep the minimum path sum for each nodes in the current level,
	 * then pass it to the next level,
	 * repeat doing this, until we get to the bottom level
	 * time: O(2*n*n)
	 * space: O(n)
	 *
	 * Corner case:
	 * 1) n == 0
	 * 2) n == 1
	 *
	 *
	 */
	public int minimumTotal(int[][] triangle) {
		// write your code here
		int h = triangle.length;
		if(h == 0) return 0;

		int[] current = new int[h];
		System.arraycopy(triangle[h-1], 0, current, 0, triangle[h-1].length);
		for(int i = h - 2; i >= 0; i --){
			for(int j = 0; j < i + 1; j ++){
				current[j] = Math.min(current[j], current[j+1]) + triangle[i][j];
			}
		}
		return current[0];
	}
}
