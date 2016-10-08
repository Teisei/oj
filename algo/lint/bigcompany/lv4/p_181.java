package teisei.algo.lint.bigcompany.lv4;

/**
 * Created by Teisei on 2016/5/29.
 */
public class p_181 {
    public static void main(String[] args) {
        int a = 1, b = -1;
        System.out.println(bitSwapRequired(a, b));
    }

    /**
     * @param a, b: Two integer
     *           return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int x = a ^ b;
        int sum = 0;
        while (x > 0) {
            sum += ((x & 1) > 0) ? 1 : 0;
            x = x >> 1;
        }
        while (x < 0) {

        }
        return sum;
    }
}
