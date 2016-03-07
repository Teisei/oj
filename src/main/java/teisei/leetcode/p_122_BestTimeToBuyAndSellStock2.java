package teisei.leetcode;

/**
 * Created by Teisei on 2016/3/7.
 */
public class p_122_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        p_122_BestTimeToBuyAndSellStock2 test = new p_122_BestTimeToBuyAndSellStock2();
        test.run();

    }

    public void run() {
        int prices[] = {
                1, 2, 3, 4, 5, 6
        };
        System.out.println(maxProfit1(prices));

    }

    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        if (prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][len + 1];
        dp[0][1] = 0 - prices[0];
        for (int i = 1; i < len; i++) {
            for (int j = 1 - i % 2; j <= i + 1 && j <= len / 2; j += 2) {
                int tmp = Integer.MIN_VALUE;
                if (j > 0) tmp = Math.max(tmp, dp[i - 1][j - 1] - prices[i]);
                if (j < i + 1 && j < len / 2) tmp = Math.max(tmp, dp[i - 1][j + 1] + prices[i]);

                dp[i][j] = tmp;
            }
        }
        printArray(dp);

        int res = Integer.MIN_VALUE;
        for (int j = len % 2; j <= len; j += 2) {
            res = Math.max(res, dp[len - 1][j]);
        }
        return res;
    }

    public void printArray(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    public int maxProfit1(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }
}
