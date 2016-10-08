package teisei.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teisei on 2016/2/26.
 */
public class p_22_GenerateParentheses {
    public static void main(String[] args) {
        p_22_GenerateParentheses test = new p_22_GenerateParentheses();
        test.run();
    }

    public void run() {
        int n = 4;
        List<String> resList = generateParenthesis(n);
        for (String e : resList) {
            System.out.println(e);
        }
    }

    public List<String> generateParenthesis(int n) {
        return haha(n, n, 0);
    }

    public List<String> haha(int a_r, int b_r, int a_p) {
        List<String> resList = new ArrayList<>();
        if (a_r + b_r == 0) {
            resList.add("");
            return resList;
        }

        if (a_p == 0 || a_r > 0) {
            List<String> tmpList = haha(a_r - 1, b_r, a_p + 1);
            for (String e : tmpList) resList.add("(" + e);
        }
        if (a_p > 0) {
            List<String> tmpList = haha(a_r, b_r - 1, a_p - 1);
            for (String e : tmpList) resList.add(")" + e);
        }
        return resList;
    }
}
