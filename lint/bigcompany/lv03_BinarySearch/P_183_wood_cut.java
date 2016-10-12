public class P_183_wood_cut {
 	/**

	Problem:
	Given n pieces of wood with length L[i] (integer array).
	Cut them into small pieces,
	to guarantee you could have equal or more than k pieces with the same length.
	What is the longest length you can get from the n pieces of wood? Given L & k,
	return the maximum length of the small pieces.
	Notice: You couldn't cut wood into float length.

	Constraints:
	1) L: an arrays: 0 <= length;
	2) L[i]: the length of each wood, 0<= L[i] <= INT_MAX
	3) operations: cut these wood into pieces with a given length;
		restrict: wood can be cut into integers only!!!
		suppose cut these woods into T pieces;
	4) k: an integer, 0<= k <= INT_MAX, means T >= k;
	5) return: the maximum length of each pieces.

	Analysis:
	length of eac piece can be [1, max(L[i])],

	Idea:
	1)brute force
	check_ok: O(n)
	for l from max to 1,
		ok = check_ok(L, l, k)
		if ok: return l
	return 0
	time: O(max * n)

	2) binary search
	set l = 1, r = max
	keep narrow the serach range,
	time: O(log(max) * l)


	 *@param L: Given n pieces of wood with length L[i]
	 *@param k: An integer
	 *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
		if(L == null || L.length == 0){
			// invalid input
			return 0;
		}
		int minL = 1, maxL = 1;
		for(int l: L) maxL = Math.max(maxL, l);

		// binary search
		while(minL < maxL){
			int l = (maxL - minL) / 2 + minL;
			if(minL%2!=maxL%2) l++;
			boolean flag = check_ok(L, l, k);
			if(flag) minL = l;
			else maxL = l - 1;
		}
		return check_ok(L, minL, k) ? minL : 0;
    }
	private boolean check_ok(int[] L, int l, int k){
		// check if each piece is l, the number of pieces should be >= k
		int sum = 0;
		for(int i = 0; i < L.length; i ++){
			int x = L[i] / l;
			if(sum >= k - x) return true;
			sum += x;
		}
		return false;
	}
}
