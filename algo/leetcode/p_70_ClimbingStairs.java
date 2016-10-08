package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/28.
 */
public class p_70_ClimbingStairs {
    public static void main(String[] args) {
        p_70_ClimbingStairs test = new p_70_ClimbingStairs();
        test.run();
    }

    public void run() {
        int n = 0;
        System.out.println(climbStairs(n));
    }

    public int climbStairs(int n) {
        if(n==0) return 0;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
