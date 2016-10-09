package teisei.algo.bop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teisei on 2016/4/23.
 */
public class P4 {
    public static void main(String[] args) {
        int n = 4;
        String[] res = Puzzle(n);
        for (String e : res) {
            System.out.println(e);
        }
    }

    public static String[] Puzzle(int n) {
        List<String> resList = haha(n, n, 0);
        String[] res = new String[resList.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static List<String> haha(int a_r, int b_r, int a_p) {
        List<String> resList = new ArrayList<String>();

        if (a_r + b_r == 0) {
            resList.add("");
            return resList;
        }
        List<String> tmpList;
        if (a_p == 0 || a_r > 0) {
            tmpList = haha(a_r - 1, b_r, a_p + 1);
            for (String e : tmpList) resList.add("(" + e);
        }
        if (a_p > 0) {
            tmpList = haha(a_r, b_r - 1, a_p - 1);
            for (String e : tmpList) resList.add(")" + e);
        }
        return resList;
    }
}
