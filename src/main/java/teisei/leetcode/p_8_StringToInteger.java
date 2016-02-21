package teisei.leetcode;

import java.util.Stack;

/**
 * Created by Teisei on 2016/2/21.
 */
public class p_8_StringToInteger {
    public static void main(String[] args) {
        p_8_StringToInteger test = new p_8_StringToInteger();
        System.out.println(Integer.MAX_VALUE);

        test.run();
    }

    public void run() {
        String s = "+-2";
        System.out.println(myAtoi(s));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean flag = true;
        if (str.charAt(0) == '-') {
            flag = false;
            str = str.substring(1, str.length());
        } else if (str.charAt(0) == '+') {
            str = str.substring(1, str.length());
            return myAtoi(str);
        }
        Stack<Integer> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push((int) ch - 48);
        }
        int res = 0;
        int inx = 0;
        while (!stack.isEmpty()) {
            int a = stack.pop();
            if (inx > 9) {
                return 0;
            }
            if (Integer.MAX_VALUE - res < a * power10(inx)) {
                return 0;
            }
            res += a * power10(inx);
            inx ++;
        }
        if (!flag) {
            res *= -1;
        }
        return res;
    }

    public int power10(int o) {
        if (o == 0) {
            return 1;
        } else {
            return 10 * power10(o - 1);
        }
    }
}
