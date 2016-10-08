package teisei.algo.lint.bigcompany.lv1;

/**
 * Created by Teisei on 2016/4/21.
 */
public class P2 {
    public static void main(String[] args) {
        new P2().run();

    }

    public void run() {
        String A = "ABCD", B = "ACD";
        System.out.println(compareStrings(A, B));
    }

    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] num = new int[26];
        int inx;
        for (char c : A.toCharArray()) {
            inx = (int) c - 'A';
            num[inx]++;
        }
        for (char c : B.toCharArray()) {
            inx = (int) c - 'A';
            if(num[inx]==0) return false;
            else num[inx]--;
        }
        return true;
    }
}
