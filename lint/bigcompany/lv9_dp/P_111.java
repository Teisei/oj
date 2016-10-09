public class P_111 {
    /**
     * @param n: An integer
     * @return: An integer
     *
     * Constraints:
     * 1) n steps total, 0<= n <= INT_MAX
     * 2) start: 0, end: n
     * 3) each time, clime one or two steps
     * 4) OUTPUT: how many distinct way to climb to the top
     *
     * Idea:
     * dp[n] = dp[n-1] + dp[n-2]
     * dp[1] = 1,
     * dp[0] = 1,( the start point)
     * dp[2] = dp[0] + dp[1],
     * ...
     * fibonacii numbers
     * time: O(n)
     * space: O(n)
     *
     * can we op the space:
     * yes, using x0, x1, x2
     * x2 = x0 + x1,
     * then x0 = x1, x1 = x2,
     * compute the next x2
     * space: O(1)
     *
     * test case:
     * 1) 0 => 1
     * 2) 1 => 1
     * 3) 2 => 2
     * 4) 3 => 3
     * 5) 4 => 5
     * ...
     *
     */
    public int climbStairs(int n) {
        // write your code here
        if(n == 0 || n == 1) return 1;
        int x0 = 1, x1 = 1;
        for(int i = 2; i <= n; i ++){
            int x2 = x0 + x1;
            x0 = x1;
            x1 = x2;
        }
        return x1;
    }
}
