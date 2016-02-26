package teisei.leetcode;

/**
 * Created by Teisei on 2016/2/25.
 */
public class p_14_LongestCommonPrefix {
    public static void main(String[] args) {
        p_14_LongestCommonPrefix test = new p_14_LongestCommonPrefix();
        test.run();
    }

    public void run() {
        String strs[] = new String[]{
                "123456",
                "1235675",
                "12987"
        };
        System.out.println(longestCommonPrefix(strs));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for(int i=1;i<strs.length && len>0;i++){
            int tmp_len = Math.min(strs[i].length(), len);
            for(int j=0;j<tmp_len;j++){
                if(strs[0].charAt(j)!=strs[i].charAt(j)){
                    tmp_len = j;
                    break;
                }
            }
            len = Math.min(len, tmp_len);
        }
        return strs[0].substring(0, len);
    }
}
