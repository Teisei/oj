public class Solution {
    /**

	Problem: remove duplicates from a sorted array

	Constraints:
	1) a sorted array: 0<= length
	2) element: INT_MIN <= X <= INT_MAX
	3) operation: remove duplicates in place,
			make every value appears only once
	4) return the new length

	Test:
	[] => [],0
	[1] => [1],1
	[1,2,3] => [1,2,3],3
	[1,1,1] => [1],1
	[1,1,2,3,3] => [1,2,3],3
	[1,2,3] => [1,2,3],3

	Idea:
	1) using two pointers, reader and write
	set writer to the first elem, reader to the second,
	check if elem[reader] equals elem[writer],
	if yes, reader moves forward
	if not, writer moves forward,
			replace the current elem with elem[reader],
			reader moves forward
	how to end: reader to the end
	time:O(n)
	space: O(1)

     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
		if(nums == null || nums.length == 0) return 0;

		int reader = 1, writer = 0;
		while(reader < nums.length){
			if(nums[reader] != nums[writer]){
				nums[++writer] = nums[reader];
			}
			reader++;
		}
		return writer + 1;
    }
}
