package teisei.leetcode;

import java.util.HashSet;

/**
 * Created by Teisei on 2016/2/16.
 */
public class p_3_LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        p_3_LongestSubstringWithoutRepeatingChars test = new p_3_LongestSubstringWithoutRepeatingChars();
        test.run();

    }

    public void run() {
        System.out.println(lengthOfLongestSubstring("aabc"));
    }
    public int lengthOfLongestSubstring(String s) {
        int len_max = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i, len = 0;
            char ch = s.charAt(j);
            HashSet<Character> table = new HashSet<Character>();
            while (!table.contains(ch) && j < s.length()) {
                table.add(ch);
                j++;
                len++;
                if (j >= s.length()) {
                    break;
                }
                ch = s.charAt(j);
            }
            len_max = Math.max(len_max, len);
        }
        return len_max;
    }
}
