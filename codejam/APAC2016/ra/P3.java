package teisei.algo.codejam.apac2016.ra;

import teisei.algo.codejam.CodeJamTemplate;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P3 extends CodeJamTemplate {

    @Override
    public void init() {
        setDIR("./data/apac2016/ra");
        setNAME("C");
        setTYPE("small");
//        setLOCAL(System.getSecurityManager() == null);
        setLOCAL(true);
    }


    @Override
    public void run() {
        int test = sc.nextInt();
        int N, M, u, v;
        long[][] map;
        long c;

        for(int t = 1;t<=test;t++) {
            System.out.println("Case #" + t + ":");
            N = sc.nextInt();
            M = sc.nextInt();
            map = new long[N + 100][N + 100];

            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    map[i][j] = Integer.MAX_VALUE;

            int[] us = new int[M];
            int[] vs = new int[M];

            for(int j=0;j<M;j++) {
                u = sc.nextInt();
                v = sc.nextInt();
                c = sc.nextLong();
                us[j] = u;
                vs[j] = v;
                map[u][v] = map[v][u] = Math.min(c, map[u][v]);
            }
//            printMap(map, N);
//            System.out.println("************ floyed ************");

            long[][] dis = new long[N][N];
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    dis[i][j] = map[i][j];
            dis = floyed(dis, N);

//            printMap(map, N);
//            System.out.println("------------------------------------------------");
//            printMap(dis, N);

            for (int j = 0; j < M; j++) {
                u = us[j];
                v = vs[j];
                System.out.println(dis[u][v] + "\t" + map[u][v]);
                if (dis[u][v] < map[u][v]) {
                    System.out.println(j);
                }
            }
//            System.out.println();
//            System.out.println();
        }
    }

    public long[][] floyed(long[][] map, int n) {
        long[][] dis = Arrays.copyOf(map, n);
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    if(dis[i][j]>dis[i][k]+dis[k][j])
                        dis[i][j]=dis[i][k]+dis[k][j];
        return dis;
    }

    public void printMap(long[][] map, int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new P3().run0();

    }

    public void test() {

    }
}
