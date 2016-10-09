package teisei.algo.codejam.cj2015.r1a;

import teisei.algo.codejam.CodeJamTemplate;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P1 extends CodeJamTemplate {

    @Override
    public void init() {
        setDIR("./data/cj2015/r1a");
        setNAME("A");
        setTYPE("large");
        setLOCAL(System.getSecurityManager() == null);
    }

    public static void main(String[] args) {
        new P1().run0();
    }

    public void run() {
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println("Case #" + t + ": " + getMethod1(a) + " " + getMethod2(a));
        }
    }

    public int getMethod1(int[] a) {
        int res = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                res += a[i - 1] - a[i];
            }
        }
        return res;
    }

    public int getMethod2(int[] a) {
        int min_speed = 0;
        for(int i=1;i<a.length;i++) {
            if(a[i-1]>a[i])
                min_speed = Math.max(min_speed, a[i - 1] - a[i]);
        }
        int res = 0;
        for(int i=1;i<a.length;i++) {
            //if min_speed or run up
            int eat_max = a[i - 1];//eat up
            if(a[i-1]> min_speed) eat_max = min_speed;
            res += eat_max;
        }
        return res;
    }

}
