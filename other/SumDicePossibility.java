public class SumDicePossibility {
    public double sumDicePossibility(int dice, int target) {
        int min = dice, max = 6 * dice;
        if (target < min || target > max) return 0.0;

        int[][] dp = new int[dice + 1][max + 1];
        for (int j = 0; j <= max; j ++) {
            dp[1][j] = j <= 6 ? 1 : 0;
        }
        for (int i = 2; i <= dice; i ++) {
            for (int j = 0; j <= max; j ++) {
                dp[i][j] = -1;
            }
        }
        int sum = 0;
        for (int j = min; j <= max; j ++) {
            sum += search(dp, dice, j);
        }
        //assert must by valid
        double res = (double) dp[dice][target] / (double) sum * 100;
        return res;
    }
    private int search(int[][] dp, int i, int j) {
        if (i < 1 || j <= 0) {
            return 0;
        }
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        int sum = 0;
        for (int k = 1; k <= 6; k ++) {
            sum += search(dp, i - 1, j - k);
        }
        dp[i][j] = sum;
        return sum;
    }

    public static void main(String args[]) {
        SumDicePossibility sol = new SumDicePossibility();
        int dice = 2;
        int target = 6;
        System.out.println(sol.sumDicePossibility(dice, target));
    }
}
