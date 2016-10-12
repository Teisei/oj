public class P_159_find-minimum-in-rotated-sorted-array {
	 /**

	 Test cases:
	 without rotate: [1,2,3,4,5,6] => 1
	 with rotate: [6,8,1,2,4] => 1
	 null or empty: null or [] => Integer.MIN_VALUE

	 * @param num: a rotated sorted array
	 * @return: the minimum number in the array
	 */
	 public int findMin(int[] num) {
		 // write your code here
		 if(num == null || num.length == 0) return Integer.MIN_VALUE;
		 int n = num.length;
		 int pivot = num[n - 1];
		 int l = 0, r = n - 1;
		 while(l < r){
			 int m = (r - l) / 2 + l;
			 if(num[m] <= pivot) r = m;
			 else l = m + 1;
		 }
		 return num[l];
	 }
}
