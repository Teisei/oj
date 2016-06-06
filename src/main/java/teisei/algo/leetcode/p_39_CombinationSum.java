package teisei.algo.leetcode;

import java.util.*;

/**
 * Created by Teisei on 2016/6/5.
 */
public class p_39_CombinationSum {


    Set<Integer> hash = new HashSet<>();

    public static void main(String[] args) {
        new p_39_CombinationSum().run();

    }

    public void run() {
        int[] candidate = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidate, target);
        System.out.println();
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for(int x: candidates) hash.add(x);

        List<List<Integer>> resList = new ArrayList<>();

        if(hash.contains(target))
            resList.add(new ArrayList<>(Arrays.asList(target)));

        for(int i = 1;target-i>=i;i++) {
            haha(resList, new ArrayList<Integer>(), i, target - i);
        }
        return resList;
    }

    private void haha(List<List<Integer>> resList, List<Integer> list, int x, int y) {
        if(!hash.contains(x)) return;

        List<Integer> tmpList;

        if (hash.contains(y)) {
            tmpList = copyList(list);
            tmpList.add(x);
            tmpList.add(y);
            resList.add(tmpList);
        }

        tmpList = copyList(list);
        tmpList.add(x);

        for(int i=x;y-i>=i;i++) {
            haha(resList, tmpList, i, y - i);
        }
    }

    private List<Integer> copyList(List<Integer> list) {
        List<Integer> resList = new ArrayList<>();
        for(int x: list) resList.add(x);
        return resList;
    }
}
