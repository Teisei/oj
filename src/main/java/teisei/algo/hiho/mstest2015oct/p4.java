package teisei.algo.hiho.mstest2015oct;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/5.
 */
public class p4 {

    static int pointer = 0;
    static int N = 0, M =0;
    static char[] arr = new char[50033];

    public static void run() {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();

        String input = sc.nextLine();
        arr = input.toCharArray();

        int test = 0;
        while(test++ <M ){
            String cmd = sc.nextLine();
            String rec[] = cmd.split(" ");
            int cmd_type = Integer.parseInt(rec[1]);
            int i, j, K;
            if (cmd_type == 1) {
                i = Integer.parseInt(rec[2]);
                j = Integer.parseInt(rec[3]);
                char Z = rec[4].charAt(0);
                CMD1(i, j, Z);
            } else if (cmd_type == 2) {
                i = Integer.parseInt(rec[2]);
                j = Integer.parseInt(rec[3]);
                K = Integer.parseInt(rec[4]);
                CMD2(i, j, K);
            } else if (cmd_type == 3) {
                K = Integer.parseInt(rec[2]);
                CMD3(K);
            } else if (cmd_type == 4) {
                i = Integer.parseInt(rec[2]);
                j = Integer.parseInt(rec[3]);
                if(i>j) continue;
                CMD4(i, j);
            } else {

            }
        }
        printArray();
    }

    /**
     *
     */
    public static void CMD1(int s, int t, char Z){
        s = (s + pointer) % N;
        t = (t + pointer) % N;
        s = s == 0 ? N : s;
        t = t == 0 ? N : t;
        if (s <= t) {
            for (int i = s - 1; i <= t - 1; i++) arr[i] = Z;
        } else {
            CMD1(s, N, Z);
            CMD1(0, t, Z);
        }
    }

    /**
     * turn the ith to the jth rotators up K times
     * ABCDEFG => CMD 2 2 3 1 => ACDDEFG
     */
    public static void CMD2(int s, int t, int K) {
        K %= 26;
        s = (s + pointer) % N;
        t = (t + pointer) % N;
        s = s == 0 ? N : s;
        t = t == 0 ? N : t;
        if (s <= t) {
            for (int i = s - 1; i <= t - 1; i++) {
                int id = (int) arr[i] + K;
                if (id > (int) 'Z') id -= 26;
                arr[i] = (char) id;
            }
        } else {
            CMD2(s, N, K);
            CMD2(0, t, K);
        }
    }

    /**
     * move the K leftmost rotators to the rightmost end
     * For example: ABCDEFG => CMD 3 3 => DEFGABC
     */
    public static void CMD3(int K) {
        K %= 26;
        pointer = (pointer + K) % N;
        pointer = pointer == 0 ? N : pointer;
    }


    public static void CMD4(int s, int t){
        s %= N;
        s = s == 0 ? N : s;
        t %= N;
        t = t == 0 ? N : t;
        if (s <= t) {
            for (int i = s; i <= t; i++) {
                CMD2(i, i, i - s + 1);
            }
        } else {
            for(int i=1;i<=t;i++)
                CMD2(i, i, i-1+1);
            for(int i=s;i<=N;i++)
                CMD2(i, i, i-s+1);
        }
    }

    public static void main(String[] args) {
        run();
    }

    public static void test() {
        N = 7;
        String str = "ABCDEFG";
        arr = str.toCharArray();
//        CMD4(2, 3);
        CMD3(3);
        for(int i=0;i<N;i++) {
            int inx = pointer + i;
            if(inx>=N) inx %= N;
            System.out.print(arr[inx]);
        }
        System.out.println();
    }

    public static void printArray() {
        for(int i=0+pointer;i<N+pointer;i++) {
            int inx = (i >= N) ? i % N : i;
//            System.out.println(pointer + "\t" + i + "\t" + inx);
            System.out.print(arr[inx]);
        }
        System.out.println();
    }
}
