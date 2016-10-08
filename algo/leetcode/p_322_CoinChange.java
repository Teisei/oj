package teisei.algo.leetcode;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/2/27.
 */
public class p_322_CoinChange {
    public static void main(String[] args) {
        p_322_CoinChange test = new p_322_CoinChange();
        test.run();
    }

    public void run() {
        int[] x = new int[]{1, 2, 5};
        x = new int[]{186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(x, amount));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[][] = new int[coins.length][amount + 1];
        for(int i=0;i<=amount;i++)
            dp[0][i] = i % coins[0] == 0 ? i / coins[0]: -1;
        for(int i=1;i<coins.length;i++) {
            int x = coins[i];
            for (int j = 0; j <= amount; j++) {
//                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
                if (j - x < 0){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = -1;
                    int a = dp[i][j - x] == -1 ? Integer.MAX_VALUE : dp[i][j - x] + 1;
                    int b = dp[i - 1][j] == -1 ? Integer.MAX_VALUE : dp[i - 1][j];
                    dp[i][j] = Math.min(a, b);
                    if (dp[i][j] == Integer.MAX_VALUE) {
                        dp[i][j] = -1;
                    }
                }
            }
        }
        boolean flag = false;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++) {
            if (dp[i][amount] != -1) {
                res = Math.min(res, dp[i][amount]);
                flag = true;
            }
        }
        return flag ? res : -1;
    }
}
