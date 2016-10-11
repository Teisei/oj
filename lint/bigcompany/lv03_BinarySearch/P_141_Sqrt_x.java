class Solution {
    /**

	Problem:
	Implement int sqrt(int x).
	Compute and return the square root of x.

	Constraints:
	1) x: integer, INT_MIN <= X <= INT_MAX
	2) if x<0,  sqrt(x) is invalid, return a random integer;
	3) if x>=0, sqrt(x) should be a interger not larger than x
	4) return sqrt(x)

	Idea:
	1) brute
	res = Max([t where t*t <= x for t in [0, x]])
	time: O(x), O(sqrt(x))
	space: O(1)

	2) binary search
	transform t * t ? x => t ? x / t; to avoid integer out of bound;
	1. if t = x / t ==> res == t;
	2. if t < x / t ==> res >= t;
	3. if t > x / t ==>	res < t;

     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
		if(x <= 0) return 0;

		int l = 0, r = x;
		while(l < r){
			int t = (r - l) / 2 + l;
			if(l%2!=r%2) t++;
			if(t == x / t) return t;
			else if(t < x / t) l = t;
		 	else r = t - 1;
		}
		return l;
    }
}
