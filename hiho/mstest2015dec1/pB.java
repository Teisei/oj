package teisei.algo.hiho.mstest2015dec1;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/6.
 */
public class pB {
    static int N, M;
    static int edge[];
    static int dp[][];
    static int p[];

    public static void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        edge = new int[N + 1];
        dp = new int[N+1][5050];
        p = new int[1 << 14];
        for (int i = 0; i < N; ++i)
            p[ 1 << i ] = i + 1;

        for(int i=0;i<=N;i++)
            for(int j=0;j<=5000;j++)
                dp[i][j] = -1;

        for (int i = 1; i <= M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edge[from] |= 1 << (to - 1);
        }
        int res = dfs(1, (1 << N) - 2);
        System.out.println(res);
    }

    public static int dfs(int nowVertex, int unused) {
        int res = 0;
        /**  if used up */
        if (unused == 0) {
            res = (edge[nowVertex] & 1);
            return res;
        }
        int rest = unused & edge[ nowVertex ];
        while(rest>0){
            int tp = rest & (-rest);
            if (dp[p[tp]][unused - tp]==-1) {
                dp[p[tp]][unused - tp] = dfs(p[tp], unused - tp);
            }
            res+=dp[p[tp]][unused - tp];
            rest -= tp;
        }
        return res;
    }

    public static void main(String[] args) {
        run();
    }
}
