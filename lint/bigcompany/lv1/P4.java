package teisei.algo.lint.bigcompany.lv1;

import java.util.*;

/**
 * Created by Teisei on 2016/4/21.
 */
public class P4 {
    public static void main(String[] args) {
        new P4().run();

    }

    public void run() {
        String[] strs = new String[]{
                "code2", "lint", "code1", "intl", "inlt", "code"
        };
        List<String> resList = anagrams(strs);
        for (String e : resList) {
            System.out.println(e);
        }
    }

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        char[][] chs = new char[strs.length][];
        for(int i=0;i<strs.length;i++) {
            chs[i] = strs[i].toCharArray();
            Arrays.sort(chs[i]);
        }
        Map<String, List<Integer>> tmpMap = new HashMap<>();
        for(int i=0;i<chs.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<chs[i].length;j++) {
                sb.append(chs[i][j]);
            }
            if(!tmpMap.containsKey(sb.toString())) tmpMap.put(sb.toString(), new ArrayList<Integer>());
            tmpMap.get(sb.toString()).add(i);
        }

        List<String> resList = new ArrayList<>();

        for (String str : tmpMap.keySet()) {
            if (tmpMap.get(str).size() > 1) {
                for (int inx : tmpMap.get(str)) {
                    resList.add(strs[inx]);
                }
            }
        }
        return resList;
    }
}
