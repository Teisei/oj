package teisei.hiho.ms_2014_intern;

import java.util.Scanner;

/**
 * 最长降序子序列
 * Created by Teisei on 2016/4/5.
 */
public class p3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x[] = {9, 8, 4, 6, 5, 10, 3, 2, 1};
        x = new int[]{1, 2, 3, 4, 5};
        System.out.println(process(x));

    }

    public static void run() {
        while (sc.hasNextLine()) {
            String rec[] = sc.nextLine().split(",");
            int[] x = new int[rec.length];
            for (int i = 0; i < rec.length; i++) {
                x[i] = Integer.parseInt(rec[i]);
            }
            process(x);
        }
    }

    /**
     * longest common substring
     * @param x
     * @return
     */
    public static String process(int[] x) {
        int dp[] = new int[x.length];
        int fa[] = new int[x.length];
        dp[0] = 1;
        fa[0] = -1;
        for (int i = 1; i < x.length; i++) {
            int i_max = -1;
            dp[i] = 0;
            for (int j = i - 1; j > i_max; j--) {
                /* if the current value is less than the previous one
                 * and
                 * number is large the current number
                 * */
                if (x[i] < x[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    i_max = Math.max(i_max, fa[j]);
                    fa[i] = j;
                }
            }
        }
        /**
         * find the tail of the longest sequence
         */
        int n_max = 0;
        int i_max = -1;
        for (int i = 0; i < dp.length; i++) {
            if (n_max < dp[i]) {
                n_max = dp[i];
                i_max = i;
            }
            n_max = Math.max(n_max, dp[i]);
        }
        int i_end = i_max;
        int i_start = i_end;
        while (fa[i_start] > -1) {
            i_start = fa[i_start];
        }
        return i_start + "..." + i_end;
    }
}
