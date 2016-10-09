package teisei.algo.codejam.cj2015.r1b;

import teisei.algo.codejam.CodeJamTemplate;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P extends CodeJamTemplate {

    @Override
    public void init() {
        setDIR("./data/cj2015/r1a");
        setNAME("B");
        setTYPE("large");
        setLOCAL(System.getSecurityManager() == null);
    }


    @Override
    public void run() {
    }

    public static void main(String[] args) {
        new P().run0();
    }

}
