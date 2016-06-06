package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/21.
 */
public class p_8_StringToInteger {
    public static void main(String[] args) {
        p_8_StringToInteger test = new p_8_StringToInteger();
        test.run();
    }

    public void run() {
        int a = 2147483647;
        String s = "2147483648";
        System.out.println(myAtoi(s));
    }

    public int myAtoi(String str) {
        char[] chs = str.toCharArray();
        int N = chs.length;
        if (N == 0) return 0;

        int s = 0;
        while (chs[s] == ' ' && s < N) s++;
        if (s >= N) return 0;

        int i = s;
        boolean isPositive = true;
        if (chs[s] == '-' || chs[s] == '+') {
            isPositive = chs[s] == '-' ? false : true;
            i++;
        }
        int base = 0;
        while (i < N) {
            int d = (int) chs[i] - 48;
            if (d < 0 || d > 9) break;
            if (d < 0) break;
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && d > 7)) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + d;
            i++;
        }
        base *= isPositive ? 1 : -1;
        return base;
    }
}
