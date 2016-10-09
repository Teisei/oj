package teisei.algo.codejam.cj2016.r1a;

import teisei.algo.codejam.CodeJamTemplate;

/**
 * Created by Teisei on 2016/4/16.
 */
public class Pa extends CodeJamTemplate {
    public static void main(String[] args) {
        new Pa().run0();

    }

    @Override
    public void run() {
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            haha(t);
        }
    }

    public void haha(int test) {
        int N = sc.nextInt();
        int num[] = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
            sum += num[i];
        }
        String res = "Case #" + test + ":";
        while (sum > 0) {
            String tmp = "";
            if (sum == 2) {
                for (int i = 0; i < N; i++) {
                    if (num[i] == 1) {
                        tmp += getCh(i);
                        num[i]--;
                    }
                }
                sum -= 2;
                res += " "+tmp;
            } else if (sum == 3) {
                for (int i = 0; i < N; i++) {
                    if (num[i] == 1) {
                        tmp += getCh(i);
                        num[i]--;
                        break;
                    }
                }
                sum--;
                res += " "+tmp;
            } else if (sum >= 4) {
                int m1 = -1, m2 = -1;
                int i1 = -1, i2 = -1;
                for (int i = 0; i < N; i++) {
                    if (num[i] > m1) {
                        m1 = num[i];
                        i1 = i;
                    }
                }
                for (int i = 0; i < N; i++) {
                    if (i != i1) {
                        if (num[i] > m2) {
                            m2 = num[i];
                            i2 = i;
                        }
                    }
                }
                tmp = getCh(i1) + "" + getCh(i2);
                num[i1]--;
                num[i2]--;
                sum -= 2;
                res += " "+tmp;
            } else {

            }
        }
        System.out.println(res);

    }

    @Override
    public void init() {
        setDIR("./data/cj2016/r1c");
        setNAME("A");
        setTYPE("small-attempt0");
//        setLOCAL(System.getSecurityManager() == null);
        setLOCAL(true);
    }

    public char getCh(int i) {
        return (char) ((int) 'A' + i);
    }
}
