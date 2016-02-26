package teisei.leetcode;

/**
 * Created by Teisei on 2016/2/26.
 */
public class p_62_UniquePaths {
    public static void main(String[] args) {
        p_62_UniquePaths test = new p_62_UniquePaths();
        test.run();
    }

    public void run() {
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if (dp[i][j] == 0) {
                    if(i-1>0) dp[i][j] += dp[i - 1][j];
                    if(j-1>0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
