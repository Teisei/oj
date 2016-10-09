package teisei.algo.leetcode;

import java.util.*;

/**
 * Created by Teisei on 2016/6/5.
 */
public class p_40_CombinationSumII {

    public static void main(String[] args) {
        new p_40_CombinationSumII().run();

    }

    public void run() {
        int[] candidate = new int[]{1};
        int target = 2;
        List<List<Integer>> lists = combinationSum2(candidate, target);
        System.out.println();
    }

    Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int x : candidates) {
            if (!map.containsKey(x)) map.put(x, 1);
            else map.put(x, map.get(x) + 1);
        }

        List<List<Integer>> resList = new ArrayList<>();

        if (map.containsKey(target))
            resList.add(new ArrayList<>(Arrays.asList(target)));

        for (int i = 1; target - i >= i; i++) {
            haha(resList, new ArrayList<Integer>(), i, target - i);
        }
        return resList;
    }


    private void haha(List<List<Integer>> resList, List<Integer> list, int x, int y) {
        if (!map.containsKey(x)) return;
        if (map.get(x) == 0) return;


        //remove this element
        map.put(x, map.get(x) - 1);


        List<Integer> tmpList;

        if (map.containsKey(y)) {
            if (map.get(y) > 0) {
                tmpList = copyList(list);
                tmpList.add(x);
                tmpList.add(y);
                resList.add(tmpList);
            }
        }

        tmpList = copyList(list);
        tmpList.add(x);

        for (int i = x; y - i >= i; i++) {
            haha(resList, tmpList, i, y - i);
        }

        //return this element
        map.put(x, map.get(x) + 1);

    }

    private List<Integer> copyList(List<Integer> list) {
        List<Integer> resList = new ArrayList<>();
        for (int x : list) resList.add(x);
        return resList;
    }


}
