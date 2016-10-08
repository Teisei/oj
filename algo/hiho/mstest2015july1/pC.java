//package teisei.algo.hiho.mstest2015july1;
//
//import java.util.Scanner;
//
///**
// * Created by Teisei on 2016/4/6.
// */
//public class pC {
//
//    static Scanner sc = new Scanner(System.in);
//    static int T, L, R, N, Q;
//    static boolean[][][] isOk;
//    final static int MAX_TIME = 100000100;
//
//    public static void main(String[] args) {
//        int task = sc.nextInt();
//        while (task-- > 0) {
//            run();
//        }
//    }
//
//    public static void run() {
//        T = sc.nextInt();// arrives at time T
//        L = sc.nextInt();// spend L units of time
//        R = sc.nextInt();// R rounds
//        N = sc.nextInt(); //lanes 0-N-1
//        Q = sc.nextInt(); //other people have Q plans
//        isOk = new boolean[N][2][MAX_TIME];
//        int t, l, n, d;
//        for (int i = 0; i < Q; i++) {
//            t = sc.nextInt();//he starts at t time
//            l = sc.nextInt();//the time he spends
//            n = sc.nextInt();//the n-th lane
//            d = sc.nextInt();//the direction he choose
//
//            int start = 0;
//            int end = -1;
//            if (l < L) {
//                /**  he is faster */
//                start = t + l - L + 1;
//                end = t - 1;
//                if (start >= 0 && start >= end) {
//                    System.out.println("[" + end + "," + start + "]");
//                    for(int j=start;j<=end;j++)
//                        isOk[n][d][j] = true;
//                }
//            } else if (l == L) {
//                int start = t;
//                int end = t;
//                for(int j=start;j<=end;j++)
//                    isOk[n][d][j] = true;
//                System.out.println("[" + start + "," + end + "]");
//            } else {
//                /**  I am faster */
//                int start = t + 1;
//                int end = t + l - L - 1;
//                if (start <= end) {
//                    System.out.println("[" + start + "," + end + "]");
//                    for(int j=start;j<=end;j++)
//                        isOk[n][d][j] = true;
//                }
//            }
//        }
//    }
//}
