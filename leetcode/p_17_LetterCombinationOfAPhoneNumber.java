package teisei.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Teisei on 2016/2/25.
 */
public class p_17_LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        p_17_LetterCombinationOfAPhoneNumber test = new p_17_LetterCombinationOfAPhoneNumber();
        test.run();
    }

    public void run() {
        String str = "909";
        List<String> resList = letterCombinations(str);
        for (String e : resList) {
            System.out.println(e);
        }
    }

    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("0", "");
        map.put("1", "");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if(digits.length()==0) return new ArrayList<>();
        else return dfs(map, digits);

    }
    public List<String> dfs(Map<String, String> map, String digits){
        List<String> resList = new ArrayList<>();
        if(digits.length()==0){
            resList.add("");
            return resList;
        }else{
            String ch = "" + digits.charAt(0);
            String chs = map.get(ch);
            List<String> outList = new ArrayList<>();
            if(chs.length()==0) outList.add("");
            else
                for(int k=0;k<chs.length();k++)
                    outList.add("" + chs.charAt(k));
            List<String> tmpList = dfs(map, digits.substring(1, digits.length()));
            for (String a : outList)
                for(String b: tmpList)
                    resList.add(a + b);
        }
        return resList;
    }
}
