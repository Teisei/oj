package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/21.
 */
public class p_7_ReverseInteger {
    public static void main(String[] args) {
        p_7_ReverseInteger test = new p_7_ReverseInteger();
        test.run();
    }

    public void run() {
        int x = -2147483648;
            x = 1463847412;
        System.out.println(reverse(x));
    }
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            // handle overflow/underflow
            if (Math.abs(ret) > 214748364) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
