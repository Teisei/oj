package teisei.algo.hiho.mstest2015oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Teisei on 2016/4/5.
 */
public class p3 {
    public static void main(String[] args) {
        String str1 = "abcdefghijklmn";
        String str2 = "ababceghjklmn";

        Map<String, List<Integer>> map1 = getSubstringMap(str1);
        Map<String, List<Integer>> map2 = getSubstringMap(str2);
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                System.out.println(key);
            }
        }
    }

    public static Map<String, List<Integer>> getSubstringMap(String str) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<str.length()-2;i++) {
            for (int l = 3; i + l <= str.length(); l++) {
                String key = str.substring(i, i+l);
                if(!map.containsKey(key)) map.put(key, new ArrayList<Integer>());
                map.get(key).add(i);
            }
        }
        return map;
    }
}
