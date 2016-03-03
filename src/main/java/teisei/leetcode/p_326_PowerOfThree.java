package teisei.leetcode;

/**
 * Created by Teisei on 2016/3/3.
 */
public class p_326_PowerOfThree {
    int _MAX_X_ = 1290;

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        p_326_PowerOfThree test = new p_326_PowerOfThree();
        test.run();
    }

    public void run() {
        //2147483647
        // 387420489
        //1162261467
        int p = 1, i = 0, x = 3;
        System.out.println(x + "^" + i + " = " + p);
        while (p < Integer.MAX_VALUE / x) {
            p *= x;
            System.out.println(x + "^" + ++i + " = " + p);
        }
    }

    public boolean isPowerOfThree(int n) {
        return isPowerOfX(n, 3);
    }

    public boolean isPowerOfX(int n, int x) {
        int p = 1;
        while (p < n) {
            p = p * x;
            if(p>Integer.MAX_VALUE/x || p<Integer.MIN_VALUE/x) break;
        }
        return p == n;
    }
}
