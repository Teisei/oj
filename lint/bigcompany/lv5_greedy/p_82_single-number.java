public class Solution {
    /**

	Problem:
	Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

	Idea:
	1) sort the array, scan and find the single one
	time: O(n log n)

	2)
	suppose every number is 8 digits
	a ^ a = 00000000
	a ^ 0 = a
	so if we do ^ operation for all numbers in the array,
	the final result will be the single one
	time: O(n)


      *@param A : an integer array
      *return : a integer
      */
	  public int singleNumber(int[] A) {
          // Write your code here
  		if(A == null || A.length == 0) return 0;
  		int mask = 0;
  		for(int x: A){
  			mask = mask ^ x;
  		}
  		return mask;
      }
}
