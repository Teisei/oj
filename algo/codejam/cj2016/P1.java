package teisei.algo.codejam.cj2016;

import teisei.algo.codejam.CodeJamTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P1 extends CodeJamTemplate{

    @Override
    public void init() {
        setDIR("./data/cj2016");
        setNAME("A");
        setTYPE("test");
        setLOCAL(System.getSecurityManager() == null);
    }

    public static void main(String[] args) {
        new P1().run0();
    }

    public void run() {
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int N = sc.nextInt();
            int res = getN(N);
            if (res > 0) {
                System.out.println("Case #" + i + ": " + res);
            } else {
                System.out.println("Case #" + i + ": INSOMNIA");
            }
        }
    }

    public int getN(int N) {
        int inx = 1;
        Map<Integer, Integer> map = new HashMap<>();
        while (map.size() < 10 && inx < 1000000) {
            int rest = N * inx;
            while (rest > 0) {
                int remainder = rest % 10;
                if (!map.containsKey(remainder)) map.put(remainder, 1);
                rest /= 10;
            }
            if(map.size()==10) break;
            inx++;
        }
        return map.size() == 10 ? N * inx : -1;
    }






}
