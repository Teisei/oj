package teisei.algo.lint.bigcompany.lv1;

/**
 * Created by Teisei on 2016/4/21.
 */
public class P6 {
    public static void main(String[] args) {
        new P6().run();
    }

    public void run() {
        String strs[] = new String[]{
                "ABCD", "ABEF", "ACEF"
        };
        strs = new String[]{
                "ABCDEFG", "ABCEFG", "ABCEFA"
        };
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        int n = strs.length, inx = 0;
        if (n == 0) return "";
        if (n == 1) return strs[0];
        while (true) {
            if (inx >= strs[0].length()) break;

            char c = strs[0].charAt(inx);
            boolean finish = false;

            for (int i = 1; i < n; i++) {
                // if length is not enough
                if (inx >= strs[i].length()) {
                    finish = true;
                    break;
                }
                // if not equal
                if (strs[i].charAt(inx) != c) {
                    finish = true;
                    break;
                }
            }
            if (finish)
                break;
            inx++;
        }
        return strs[0].substring(0, inx);

    }
}
