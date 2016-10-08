public class P_41 {
	/**
	 * Problem:
	 * Given an array of integers, find a contiguous subarray which has the largest sum.
	 *
	 * @param nums: A list of integers
	 * @return: A integer indicate the sum of max subarray
	 *
	 * Constraints:
	 * 1) array: integer, 0<= length <= INT_MAX
	 * 2) element: integer, INT_MIN <= X <= INT_MAX
	 * 3) a contiguous subarray: consective elements, 1<= length
	 * 4) with the largest sum: integer, not overflow
	 *
	 * Idea:
	 * 1) brute force
	 * for each i,j, 0<=i<=j<=n,
	 * compute the sum through i to j, keep the max one
	 * time: O(n ^ 3)
	 * space: O(1)
	 *
	 * 2)
	 * maxsum[i] represents a subarry ends at position i with the largest sum,
	 * then maxsum[i] = num[i] + maxsum[i-1], if maxsum[i-1] > 0
	 *                = num[i], else
	 * special case:
	 * maxsum[0] = num[0]
	 * time: O(n)
	 * space: O(n)
	 *
	 * 3) using local and global
	 * local[i] means the maximum sum subarray selected from 0~i-1, i-1 should be the end
	 * global[i] means the maximum sum subarray selected from 0~i-1, i-1 not necessaily to be the end position
	 * local[i] = max{nums[i-1], local[i-1]+nums[i-1]}
	 * global[i] = max{local[i], global[i-1]}
	 *
	 * can we op the space: yes
	 * keep the max, previous maxsum, to compute the current maxsum
	 * time: O(n)
	 * space: O(1)
	 *
	 * test cases:
	 * 1) [] => 0
	 * 2) [1] => 1
	 * 3) [99999] => 99999
	 * 4) [1,-2,3,-1,3,4] => 9
	 * 5) [2, INT_MAX-2, INT_MIN+4, 2, INT_MAX-4] => INT_MAX
	 *
	 *
	 */
	public int maxSubArray(int[] nums) {
		// write your code
		if(nums == null || nums.length == 0){
			return Integer.MIN_VALUE;
		}
		int n = nums.length;
		int dp = nums[0];
		int max = dp;

		for(int i = 1; i < n; i ++){
			dp = dp > 0 ? dp : 0;
			dp = dp + nums[i];
			max = Math.max(max, dp);
		}
		return max;
	}
}
