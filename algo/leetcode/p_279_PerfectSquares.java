package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/3/15.
 */
public class p_279_PerfectSquares {
    public int numSquares(int n) {
        int r = (int)Math.sqrt(n);
        int[][] dp = new int[r+1][n+1];
        for(int j=0;j<=n;j++)
            dp[1][j]=j;
        for(int i=2;i<=r;i++){
            for(int j=0;j<=n;j++){
                if(j-i*i>=0){
                    dp[i][j] = Math.min(dp[i][j-i*i]+1, dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[r][n];
    }
}
