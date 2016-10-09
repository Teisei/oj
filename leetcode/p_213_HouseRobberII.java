package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/4/20.
 */
public class p_213_HouseRobberII {
    public static void main(String[] args) {
        new p_213_HouseRobberII().run();

    }

    public void run() {
        int[] a = {1, 3, 1, 3, 100};
        System.out.println(rob(a));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(getDP(nums, 0, n-2, false), getDP(nums, 1, n-1, false));
    }
    public int getDP(int[] nums, int left, int right, boolean direction){
        int n = nums.length;
        if(left>right) return 0;
        if(left==right) return nums[left];
        if(left==right-1) return Math.max(nums[left], nums[right]);

        int dp[] = new int[n];
        int p, bound, step;
        if(direction){
            p = left;
            bound = right;
            step=1;
        }else{
            p = right;
            bound = left;
            step = -1;
        }
        dp[p] = nums[p];
        p += step;
        dp[p] = Math.max(nums[p-step], nums[p]);
        p += step;
        while(p!=bound+step){
            dp[p] = Math.max(dp[p-step-step]+nums[p], dp[p-step]);
            p += step;
        }
        return dp[p-step];
    }
}
