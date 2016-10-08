package teisei.algo.hiho.mstest2016april1;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/6.
 */
public class P4 {

    static Scanner sc = new Scanner(System.in);


    public static void run() {

    }

    public static void main(String[] args) {
        int w = 6;
        int para = 19;
        int res = 0;
        if(para%w==0) res = para / w;
        else res = para / w + 1;
        System.out.println(res);
    }

    public static void test() {

    }
}
