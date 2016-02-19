package teisei.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Teisei on 2016/2/19.
 */
public class p_5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        p_5_LongestPalindromicSubstring test = new p_5_LongestPalindromicSubstring();
        test.run();
    }

    public void run() {
        String str = "121abcba97897";
        System.out.println(longestPalindrome0(str));
//        str = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
//        System.out.println("**************");
//        longestPalindrome(str);longestPalindrome1(str);
//        System.out.println("**************");
//        str = str + str;longestPalindrome(str);longestPalindrome1(str);
//        System.out.println("**************");
//        str = str + str;longestPalindrome(str);longestPalindrome1(str);
//        System.out.println("**************");
//        str = str + str;longestPalindrome(str);longestPalindrome1(str);
//        System.out.println("**************");
//        str = str + str;longestPalindrome(str);longestPalindrome1(str);
//        System.out.println("**************");
    }

    public String longestPalindrome0(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String longest = "";
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = true;
                else if (i + 1 == j && s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                else if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if (j - i + 1 > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }

    public String longestPalindrome(String s) {
        long start = System.currentTimeMillis();
        if (s.length() == 1) {
            return s;
        }
        int[] nums = new int[s.length() * 2];
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int len = nums[x];
            if (x % 2 == 0) {
                len++;
            }
            int left = x / 2;
            int right = x % 2 == 0 ? x / 2 : x / 2 + 1;
            left -= len;
            right += len;
            if (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    nums[x]++;
                    queue.add(x);
                }
            }
        }
        int x = -1;
        int len = 0;
        for(int i=0;i<nums.length;i++) {
            int len_tmp = i % 2 == 0? nums[i] * 2 + 1 :nums[i] * 2;
            if (len_tmp > len) {
                x = (i / 2) - nums[i];
                if (i % 2 != 0) {
                    x++;
                }
                len = len_tmp;
            }
        }
//        System.out.println(x + "\t" + len);
        System.out.println(System.currentTimeMillis() - start);

        return s.substring(x, x + len);
    }


    public String longestPalindrome1(String s) {
        long start = System.currentTimeMillis();
        if (s == null || s.length() == 0) {
            return "";
        }
        String longest = "";
        int len = s.length();
        // dp[i][j] means substring of s from i to j is palindrome
        boolean[][] dp = new boolean[len][len];
        // why i decrease from (len-1) to 0, but j increase from i to (len-1)?
        // think about it!
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // important to note: dp[i+1][j-1]
                    // i depends on (i+1), so i from large to small
                    // j is just the opposite, small to large
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                if (dp[i][j] && j + 1 - i > longest.length()) {
                    longest = s.substring(i, j + 1);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        return longest;
    }

}
