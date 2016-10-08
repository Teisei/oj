package teisei.algo.leetcode;

import java.util.*;

/**
 * Created by Teisei on 2016/6/5.
 */
public class p_216_CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(3 / -3);
        new p_216_CombinationSumIII().run();
    }

    public void run() {
        int k = 3, n = 9;
        List<List<Integer>> lists = combinationSum3(k, n);
        System.out.println();
    }


    Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 1; i < 10; i++) map.put(i, 1);
        List<List<Integer>> resList = new ArrayList<>();

        if (map.containsKey(n) && k == 1) {
            resList.add(new ArrayList<>(Arrays.asList(n)));
        } else {
            for (int i = 1; n - i >= i; i++) {
                haha(resList, new ArrayList<Integer>(), i, n - i, k);
            }
        }
        return resList;
    }


    private void haha(List<List<Integer>> resList, List<Integer> list, int x, int y, int k) {
        if (!map.containsKey(x)) return;
        if (map.get(x) == 0) return;


        //remove this element
        map.put(x, map.get(x) - 1);

        List<Integer> tmpList;

        if (list.size() + 2 == k) {
            if (map.containsKey(y)) {
                if (map.get(y) > 0) {
                    tmpList = copyList(list);
                    tmpList.add(x);
                    tmpList.add(y);
                    resList.add(tmpList);
                }
            }
        } else {

            tmpList = copyList(list);
            tmpList.add(x);
            for (int i = x; y - i >= i; i++) {
                haha(resList, tmpList, i, y - i, k);
            }
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
