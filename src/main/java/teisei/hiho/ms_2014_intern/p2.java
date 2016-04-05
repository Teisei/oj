package teisei.hiho.ms_2014_intern;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/5.
 */
public class p2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        run();

//        System.out.println(transInt2Two(5, 4));

    }

    public static void run() {
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(process(n, m, k));
        }
    }

    public static String process(int n, int m, int k) {
        String x_min_str = "", x_max_str = "";
        for (int i = 0; i < n; i++) x_min_str += "0";
        for (int i = 0; i < m; i++) x_min_str += "1";
        for (int i = 0; i < n; i++) x_max_str += "1";
        for (int i = 0; i < m; i++) x_max_str += "0";
        int x_min = transTwo2Int(x_min_str), x_max = transTwo2Int(x_max_str);
        int n_possbility = (x_max - x_min) / 2;
        if (k > n_possbility) return "Impossible";

        int x = x_min + 2 * (k - 1);
        return transInt2Two(x, n + m);
    }

    public static int transTwo2Int(String str) {
        char[] xs = str.toCharArray();
        int x = 0;
        for (int i = 0; i < xs.length; i++) {
            x = x * 2 + (xs[i] == '1' ? 1 : 0);
        }
        return x;
    }

    public static String transInt2Two(int x, int n) {
        String res = "";
        int xx = x;
        int t = 2;
        for(int i=0;i<n;i++) {
            res = "" + xx % t + res;
            xx = xx / t;
        }
        return res;
    }

}
