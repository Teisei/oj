package teisei.algo.lint.bigcompany.lv1;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/4/21.
 */
public class P_158 {
    public static void main(String[] args) {
        new P1().run();

    }

    public void run() {
        String s1 = "ab";
        String s2 = "ab";
        System.out.println(anagram(s1, s2));

    }

    /**
     * 写出一个函数 anagram(s, t) 去判断两个字符串是否是颠倒字母顺序构成的
     *
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int n = s.length(), m = t.length();
        if (n != m) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < n; i++) {
            if (ss[i] != tt[i]) return false;
        }
        return true;
    }
}
