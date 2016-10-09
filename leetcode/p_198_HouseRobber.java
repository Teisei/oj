package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/26.
 */
public class p_198_HouseRobber {
    public static void main(String[] args) {
        p_198_HouseRobber test = new p_198_HouseRobber();
        test.run();
    }

    public void run() {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        nums = new int[]{1};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
        if(nums==null) return 0;
        if (nums.length == 0) return 0;
        int n = nums.length;
        int dp[][] = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
