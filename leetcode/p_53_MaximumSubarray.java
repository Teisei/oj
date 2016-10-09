package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/28.
 */
public class p_53_MaximumSubarray {
    public static void main(String[] args) {
        p_53_MaximumSubarray test = new p_53_MaximumSubarray();
        test.run();
    }

    public void run() {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        nums = new int[]{-1, -1};

        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1;i<len;i++){
            dp[i] = (dp[i - 1] > 0 ? dp[i - 1] : 0) + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
