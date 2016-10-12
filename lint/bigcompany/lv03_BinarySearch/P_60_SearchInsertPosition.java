public class P_60_SearchInsertPosition {
    /**

	Problem:
	Given a sorted array and a target value,
	return the index if the target is found.
	If not, return the index where it would be if it were inserted in order.
	You may assume NO duplicates in the array.

	Constraints:
	1) sorted array: 0<= length
	2) element: INT_MIN <= x <= INT_MAX
	3) no duplicates
	4) return the position of target,
	5) not found return the position to be inserted

	Test case:
	[], 5 => 0
	[1,3,5],2 => 1
	[1,3,5,7],4 => 2
	[3,5,7],1 => 0
	[1,3,5],7 => 3

	Idea:
	1) beacause the array is sorted, we can use...
	binary search to get closer to positon of/near target
	set left, right pointer,
	compute middle one and check if it is the target,
	change left or right bound and make search range narrower
	if found, return the value;
	else: compare t with current,< or >
	:::corner case: 1) array is null or empty

     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
		if(A == null || A.length == 0) return 0;
		int l = 0, r = A.length - 1;
		while(l < r){
			int m = (r - l) / 2 + l;
			if(target == A[m]) return m;
			else if(target > A[m]) l = m + 1;
			else r = m - 1;
		}
		return target <= A[l] ? l : (l + 1);
    }
}
