package teisei.algo.hiho.mstest2015july1;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/6.
 */
public class pB {
    final static int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43};
    static long N, max_amount, out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        max_amount = 1;
        out = 1;
        dfs(1, 1, 0);
        System.out.println(out);
    }



    public static void dfs(long num, int amount, int index) {
        if (amount > max_amount || (amount == max_amount && out > num)) {
            out = num;
            max_amount = amount;
        }
        if (index > 13) return;
        int i = 1;
        while (true) {
            num *= prime[index];
            i++;
            if (num > N) return;
            dfs(num, amount * i, index + 1);
        }
    }

}
