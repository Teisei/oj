package teisei.algo.lint.bigcompany.lv1;

/**
 * Created by Teisei on 2016/4/21.
 */
public class P_79 {
    public static void main(String[] args) {
        new P5().run();
    }

    public void run() {
        String A = "ABCD", B = "CBCE";
        System.out.println(longestCommonSubstring(A, B));
    }

    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int n = A.length(), m = B.length();

        int max_len = 0;

        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.charAt(i)==B.charAt(j)){
                    dp[i][j] = (i>0&&j>0)?(dp[i-1][j-1]+1):1;
                    max_len = Math.max(max_len, dp[i][j]);
                }
            }
        }
        return max_len;
    }
}
