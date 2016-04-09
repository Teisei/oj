package teisei.algo.codejam.cj2016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P4 {
    static boolean LOCAL = System.getSecurityManager() == null;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        new P4().run0();
    }

    public void run0() {

        if (LOCAL) {
            try {
                String inputPath = "D:\\Download\\D-small-attempt0.in";
                inputPath = "D:\\Download\\D-large.in";
//                inputPath = "./data/in2.txt";
                System.setIn(new FileInputStream(inputPath));
                sc = new Scanner(System.in);

                String outputPath = "D:\\IntelliJ_Projects\\oj\\src\\main\\java\\teisei\\algo\\codejam\\cj2016\\D-large.out";
                System.setOut(new PrintStream(new FileOutputStream(outputPath)));

            } catch (Exception e) {
                e.printStackTrace();
                LOCAL = false;
            }
        }
        new P4().run();
    }

    public void run() {
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int K, S, C;
            K = sc.nextInt();
            C = sc.nextInt();
            S = sc.nextInt();
            int s = C == 1 || K == 1 ? K : K - 1;
            if (S < s) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                int start = (C == 1 || K == 1) ? 1 : 2;
                int end = K;
                //k row , k+1
                //qiantao le C ceng
                String tmp = "";
                for (int j = start; j <= end; j++) {
                    tmp += j + " ";
                }
                tmp = tmp.substring(0, tmp.length() - 1);
                System.out.println("Case #" + i + ": " + tmp);
            }
        }
    }

}
