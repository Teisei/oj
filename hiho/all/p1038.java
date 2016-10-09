package teisei.algo.hiho.all;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/5.
 */
public class p1038 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        //freopen("in.txt","r",stdin);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();

        int[] need = new int[N];
        int[] value = new int[N];

        for (int i = 0; i < N; i++) {
            need[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        int[] dp = new int[M + 1];
        for (int j = 0; j <= M; j++)
            dp[j] = j < need[0] ? 0 : value[0];
        for (int i = 1; i < N; i++) {
            for (int j = M; j >= 0; j--) {
                if (j >= need[i])
                    dp[j] = Math.max(dp[j], dp[j - need[i]] + value[i]);
            }
        }
        int v_max = 0;
        for (int j = 0; j <= M; j++)
            v_max = Math.max(v_max, dp[j]);
        System.out.println(v_max);
    }
}
