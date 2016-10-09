package teisei.algo.hiho.hiho94;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/19.
 */
public class P1 {

    boolean LOCAL = System.getSecurityManager() == null;
    String NAME = "B";
    String TYPE = "test";
    String DIR = "./data/cj2015";


    public void setLOCAL(boolean LOCAL) {
        this.LOCAL = LOCAL;
    }


    public void setNAME(String NAME) {
        this.NAME = NAME;
    }


    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public void setDIR(String DIR) {
        this.DIR = DIR;
    }

    public Scanner sc;


    public void run0() {
        init();
        if (LOCAL) {
            try {
                String inputPath = DIR + File.separator + NAME + "-" + TYPE + "." + "in";
                System.setIn(new FileInputStream(inputPath));

                sc = new Scanner(System.in);

                String outputPath = DIR + File.separator + NAME + "-" + TYPE + "." + "out";
                System.setOut(new PrintStream(new FileOutputStream(outputPath)));

            } catch (Exception e) {
                e.printStackTrace();
                LOCAL = false;
            }
        } else {
            sc = new Scanner(System.in);
        }
        run();
    }


    public int Josephus(int N, int K) {
        if (N == 1) return 0;
        if (N < K) {
            int ret = 0;
            for (int i = 2; i <= N; i++) {
                ret = (ret + K) % i;
            }
            return ret;
        }
        int ret = Josephus(N - N / K, K);
        if (ret < N % K) {
            ret = ret - N % K + N;
        } else {
            ret = ret - N % K + (ret - N % K) / (K - 1);
        }
        return ret;
    }

    public void run() {
        int test = sc.nextInt();
        int N, K;
        for (int t = 0; t < test; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            System.out.println(Josephus(N, K));

        }
    }

    public void init() {
        setLOCAL(false);
    }

    public static void main(String[] args) {
        new P1().run0();
    }

}
