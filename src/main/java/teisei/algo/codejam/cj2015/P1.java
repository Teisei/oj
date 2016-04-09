package teisei.algo.codejam.cj2015;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P1 {

    static boolean LOCAL = System.getSecurityManager() == null;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        new P1().run0();
    }

    public void run0() {

        if (LOCAL) {
            try {
                String inputPath = "D:\\Download\\D-small-attempt0.in";
                inputPath = "./data/cj2015/p1.in";
                inputPath = "D:\\Download\\A-small-practice.in";
                inputPath = "D:\\Download\\A-large-practice.in";
                System.setIn(new FileInputStream(inputPath));
                sc = new Scanner(System.in);

                String outputPath = "./data/cj2015/A-large.out";
                System.setOut(new PrintStream(new FileOutputStream(outputPath)));

            } catch (Exception e) {
                e.printStackTrace();
                LOCAL = false;
            }
        }
        new P1().run();
    }

    public void run() {
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println("Case #" + t + ": " + getMethod1(a) + " " + getMethod2(a));
        }
    }

    public int getMethod1(int[] a) {
        int res = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                res += a[i - 1] - a[i];
            }
        }
        return res;
    }

    public int getMethod2(int[] a) {
        int min_speed = 0;
        for(int i=1;i<a.length;i++) {
            if(a[i-1]>a[i])
                min_speed = Math.max(min_speed, a[i - 1] - a[i]);
        }
        int res = 0;
        for(int i=1;i<a.length;i++) {
            //if min_speed or run up
            int eat_max = a[i - 1];//eat up
            if(a[i-1]> min_speed) eat_max = min_speed;
            res += eat_max;
        }
        return res;
    }

}
