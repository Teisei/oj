package teisei.leetcode;

/**
 * Created by Teisei on 2016/2/21.
 */
public class p_9_PalindromeNumber {
    public static void main(String[] args) {
        p_9_PalindromeNumber test = new p_9_PalindromeNumber();
        test.run();
    }

    public void run() {
        int a = 0;
        System.out.println(isPalindrome(a));
    }

    public boolean isPalindrome(int a) {
        if (a < 0) {
            return false;
        }
        String astr = "" + a;
        int left = 0;
        int right = astr.length() - 1;
        boolean res = true;
        while (left < right) {
            if (astr.charAt(left) != astr.charAt(right)) {
                res = false;
                break;
            }
            left++;
            right--;
        }
        return res;
    }
}
