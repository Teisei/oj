package teisei.algo.hiho.mstest2016april1;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/6.
 */
public class P3 {


    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static char[][] maps;
    static int[][] move = new int[][]{
            {0, 1},
            {1, 0}
    };

    static int out;

    public static void init() {
        N = sc.nextInt();
        M = sc.nextInt();
        maps = new char[N+1][M+1];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            maps[i] = line.toCharArray();
        }
        out = Integer.MAX_VALUE;
    }


    public static void dfs(int i, int j, int direction, int num) {
        if(j>=M||i>=N) return;
        int ii = i + move[direction][0];
        int jj = j + move[direction][1];
        if (ii == N - 1 && jj == M - 1) {
            out = Math.min(out, (maps[ii][jj] == 'b' ? 1 : 0) + num);
            return;
        }
        if (ii >= N || jj >= M) {
            direction = (direction + 1) % 2;
            dfs(i, j, direction, num);
            return;
        }
        if (ii < N && jj<M ) {
            if (maps[ii][jj] == '.') {
                dfs(ii, jj, direction, num);
            } else {
                direction = (direction + 1) % 2;
                //remove the brick and keep going
                dfs(ii, jj, direction, num + 1);
                //ruturn the left direction

                int iii = i + move[direction][0];
                int jjj = j + move[direction][1];
                if (iii < N && jjj < M) {
                    if (maps[iii][jjj] == 'b')
                        dfs(iii, jjj, direction, num + 1);
                    else
                        dfs(iii, jjj, direction, num);
                }
            }
            return;
        }
    }

    public static void main(String[] args) {
        init();
        dfs(0, 0, 0, 0);
        System.out.println(out);
    }

    public static void test() {
    }
}
