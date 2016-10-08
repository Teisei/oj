package teisei.algo.codejam.cj2016.r1c;

import teisei.algo.codejam.CodeJamTemplate;

/**
 * Created by Teisei on 2016/4/16.
 */
public class Pb extends CodeJamTemplate {
    public static void main(String[] args) {
        new Pb().run0();

    }

    @Override
    public void run() {
        int test = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= test; t++) {
            int B = sc.nextInt();
            int M = sc.nextInt();

        }
    }

    @Override
    public void init() {
        setDIR("./data/cj2016/r1c");
        setNAME("A");
        setTYPE("small");
//        setLOCAL(System.getSecurityManager() == null);
        setLOCAL(true);
    }
}
