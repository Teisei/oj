package teisei.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Teisei on 2016/3/11.
 */
public class p_217_ContainsDuplicate {
    public static void main(String[] args) {
        p_217_ContainsDuplicate test = new p_217_ContainsDuplicate();
        test.run();
    }

    public void run() {
        int nums[] = new int[]{
                2, 4, 7, 5, 1, 3, 7, 0
        };
        System.out.println(containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int e : nums) {
//            if (map.containsKey(e)) return true;
            if(set.contains(e)) return true;
//            map.put(e, 0);
            set.add(e);
        }
        return false;
    }
}
