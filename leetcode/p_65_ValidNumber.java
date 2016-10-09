package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/5/30.
 */
public class p_65_ValidNumber {
    public static void main(String[] args) {
        new p_65_ValidNumber().run();
    }

    public void run() {
        String[] nums = new String[]{
                "0",
                "0.1",
                "abd",
                "1 a",
                "2e10"
        };
        for (String s : nums) {
            System.out.println(isNumber(s));
        }
    }

    public boolean isNumber(String s) {
        boolean flag = true;
        try {
            double x = Double.parseDouble(s);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
