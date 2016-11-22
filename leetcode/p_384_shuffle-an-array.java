public class Solution {

	/**
		Problem: Shuffle a set of numbers without duplicates.

		Constraints:
		1) array, 0<= length
		2) element: INT_MIN <= X <= INT_MAX
		3) shuffle: one element has a equal possibility,
		to be put in any position in the array.
		4) support 2 operations:
			(1) shuffle
			(2) reset

		Idea:
		1) reset: keep a copy of the original one
		2) shuffle
			for i th element, select a random on from (i, N-1)th;
			i <- for i in [0, N-1]
			Random.nextInt(i)
			time: O(N)
			space: O(N)
	*/

    // generate a random integer in [0, 10)
    // int n2 = r.nextInt(10);
    int[] ori;
    int[] cur;
    int N;
    Random r;

    public Solution(int[] nums) {
        this.ori = nums;
        this.N = this.ori.length;
        this.cur = new int[N];
        for(int i = 0; i < N; i ++){
            this.cur[i] = this.ori[i];
        }
        r = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.cur = new int[this.N];
        for(int i = 0; i < this.N; i ++){
            this.cur[i] = this.ori[i];
        }
        return this.cur;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < N - 1; i ++){
            int inx = i + this.r.nextInt(this.N - i);
            // swap i with inx
            int tmp = this.cur[inx];
            this.cur[inx] = this.cur[i];
            this.cur[i] = tmp;
        }
        return this.cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
