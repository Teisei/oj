public class P_105 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     *
	 * Problem:
	 Follow up for "Unique Paths":
	 Now consider if some obstacles are added to the grids. How many unique paths would there be?
	 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

     * Constraints:
     * 1) grid: n rows and m columns, 0<= n, m <= INT_MAX
     * 2) start point: left top, (0,0)
     * 3) target point: right bottom, (n-1, m-1)
     * 4) grid[i][j] == 1 represents this position is unreachable
     * 5) OUTPUT: the number of unique paths from start to end
     *
     * Idea:
     * dp[i][j] = x represents we can get the (i, j) throught x uniques ways,
     * dp[0][0] = 1, if it is empty, 0 if it is obstacle
     * dp[i][j] = dp[i-1][j] + dp[i][j-1], if it is empty, 0 if it is not
     * time: O(n ^ 2)
     * space: O(n ^ 2)
     *
     * can we optimize the space:
     * for each level
     * dp2[j] => dp1[j] + dp2[j-1] , if it is empty;
     * then replace dp1 with dp2
     * sapce: O(n)
     *
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int n = obstacleGrid.length;
        if(n == 0) return 0;
        int m = obstacleGrid[0].length;
        if(m == 0) return 0;

        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[n+1][m+1];
        dp[0][1] = 1;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                dp[i][j] = obstacleGrid[i-1][j-1]==1?0:(dp[i-1][j] + dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
