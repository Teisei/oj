package teisei.algo.codejam.cj2016;

import teisei.algo.codejam.CodeJamTemplate;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P4 extends CodeJamTemplate {

    @Override
    public void init() {
        setDIR("./data/cj2015");
        setNAME("B");
        setTYPE("test");
        setLOCAL(System.getSecurityManager() == null);
    }



    public static void main(String[] args) {
        new P4().run0();

    }

    public void run() {
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int K, S, C;
            K = sc.nextInt();
            C = sc.nextInt();
            S = sc.nextInt();

            int s = (int) Math.ceil((double) K / (double) C);
            if (S < s) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                String tmp = "";
                for (int i = 1; i <= K; ) {
                    int start = i, end = Math.min(K, i + C - 1);
                    tmp += " " + coverFromS2T(K, start, end);
                    i += C;
                }
                System.out.println("Case #" + t + ":" + tmp);
            }
        }
    }

    public long coverFromS2T(long K, long s, long t) {
        return getRank(K, s, t - s + 1);
    }

    public long getRank(long K, long start, long level) {
        //start from level 1
        long block = 1, rank = start;
        int lv = 1;
        while (lv++ < level) {
            block = (block - 1) * K + rank;
            rank += 1;
        }
        return (block - 1) * K + rank;
    }

}
