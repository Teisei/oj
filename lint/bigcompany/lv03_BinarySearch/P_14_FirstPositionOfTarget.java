class P_14_FirstPositionOfTarget {
 	/**

	Problem:
	For a given sorted array (ascending order) and a target number,
	find the first index of this number in O(log n) time complexity.
	If the target number does not exist in the array, return -1.

	Constraints:
	1) sorted array, 0<= length
	2) element: INT_MIN <= x <= INT_MAX, duplicates
	3) find the first index of a given target
	4) return the index
	5) in O(log n) time

	Idea:
	1) bianary serach
	difference: if we find the target in index i,
				should be possible that exist in i-1;
	so change the logic when processing A[mid] == targer,
	if A[mid] == target, right = mid
	time: O(log n)
	space: O(1)

	Test case:
	

	 * @param nums: The integer array.
	 * @param target: Target to find.
	 * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
		if(nums == null || nums.length == 0) return -1;
		int l = 0, r = nums.length - 1;
		while(l < r){
			int mid = (r - l) / 2 + l;
			if(nums[mid] == target) r = mid;
			else if(nums[mid] < target) l = mid + 1;
			else r = mid - 1;
		}
		return nums[l] == target ? l : -1;
    }
}
