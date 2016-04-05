package teisei.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(reverse(x));
    }
    public int reverse(int x) {
        boolean flag = true;
        if (x < 0) {
            flag = false;
            x = x * -1;
        }
        if (Math.abs(x) > 2147483647) {
            return 0;
        }
        List<Integer> resList = new ArrayList<>();
        int rest = x;
        while (rest != 0) {
            if (Math.abs(rest) > 214748364) {
                return 0;
            }
            int a = rest % 10;
            rest = rest / 10;
            resList.add(a);
        }
        String res = "";
        if (resList.size() == 0) {
            res = "0";
        }
        for (int a : resList) {
            res += a;
        }
        int res_int = Integer.parseInt(res);
        if (!flag) {
            res_int = -1 * res_int;
        }
        return res_int;

    }
}
