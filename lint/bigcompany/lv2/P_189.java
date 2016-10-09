public class Solution {
    /**

	Problem:
	Given an unsorted integer array, find the first missing positive integer.

	Constraints:
	1) unsorted array: 0<= length
	2) element: INT_MIN <= X <= INT_MAX
	3) first missing positive: 1,2,3,7,... => 4 is it
		you should last least scan the array

	Idea:
	1) scan the array,
	using the machanism of hash, find the index for every element
	for example, number 1 should in num[0], means the first positive
	time: O(n)
	space: O(n)

	2) follow up: if we can modify the original array?
	use a dfs to help element find where it should be!
	time: O(n)
	space: O(1)


	Test case:
	[1,2,0] => 3,
	[3,4,-1,1] => 2.

     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
		if(A == null || A.length == 0) return 1;
		int n = A.length;
		boolean[] vst = new boolean[n];
		for(int x: A){
			int index = x - 1;
			if(index >=0 && index < n) vst[index] = true;
		}
		for(int i = 0; i < n; i ++){
			if(!vst[i]) return i + 1;
		}
		return n + 1;
    }

	public int firstMissingPositive2(int[] A) {
        // write your code here
		if(A == null || A.length == 0) return 1;
		for(int i = 0; i < A.length; i ++){
			find_home(A, i, A[i]);
		}
		for(int i = 0; i < A.length; i ++){
			if(A[i] != i + 1) return i + 1;
		}
		return A.length + 1;
    }
	public void find_home(int[] A, int inx, int val){
		int index = val - 1;
		if(index != inx && 0 <= index && index < A.length){
			int new_val = A[index];
			A[index] = val;
			find_home(A, index, new_val);
		}
	}
}
