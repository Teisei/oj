package teisei.algo.lint.bigcompany.lv1;

/**
 * Created by Teisei on 2016/4/21.
 */
public class P_13 {
    public static void main(String[] args) {
        new P3().run();

    }

    public void run() {
        String source = "source", target = "target";
        System.out.println(strStr(source, target));

    }

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) return -1;
        int n = source.length(), m = target.length();
        if (n == m && n == 0) return 0;
        for (int s = 0; s < n - m + 1; s++) {

            if (strStr(source, s, target)) return s;
        }
        return -1;
    }

    public boolean strStr(String source, int s, String target) {
        int len = target.length();
        for (int i = 0; i < len; i++) {
            if (source.charAt(s + i) != target.charAt(i)) return false;
        }
        return true;
    }
}
