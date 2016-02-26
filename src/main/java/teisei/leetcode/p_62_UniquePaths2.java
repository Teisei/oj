package teisei.leetcode;

/**
 * Created by Teisei on 2016/2/26.
 */
public class p_62_UniquePaths2 {
    public static void main(String[] args) {
        p_62_UniquePaths2 test = new p_62_UniquePaths2();
        test.run();
    }

    public void run() {
        int obstacleGrid[][] = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 && obstacleGrid[i][j] == 0) {
                    if (i - 1 >= 0) dp[i][j] += dp[i - 1][j];
                    if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
