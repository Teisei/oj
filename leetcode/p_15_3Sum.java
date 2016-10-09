package teisei.algo.leetcode;

import java.util.*;

/**
 * Created by Teisei on 2016/2/22.
 */
public class p_15_3Sum {
    public static void main(String[] args) {
        p_15_3Sum test = new p_15_3Sum();
        test.run();
    }

    public void run() {
        int nums[] = {-1, 0, 1, 2, -1, -4};

        nums = new int[]{
                1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9
        };
//        List<List<Integer>> resList = twoSum(nums, 0, nums.length - 1, 10);
//        for (List<Integer> l : resList) {
//            System.out.println(l.get(0) + "+" + l.get(1));
//        }
        nums = new int[]{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6};
        nums = new int[]{0, 0, 0, 0};

        nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> ll : res) {
            for (Integer tt : ll) {
                System.out.print(tt + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length - 2;i++) {
//            System.out.println("==== nums[" + i + "]=" + nums[i]);
            int a = nums[i];
            List<List<Integer>> tmpList = twoSum(a, nums, i + 1, nums.length - 1, 0 - a);
            for (List<Integer> ttList : tmpList) {
                resList.add(ttList);
            }
            while (i < nums.length - 2) {
//                System.out.println("*** a=" + a + "  nums[i]=" + nums[i]);
                if (nums[i] > a) {
                    i--;
                    break;
                }
                i++;
            }
        }
        return resList;
    }

    public List<List<Integer>> twoSum(int a, int[] nums, int l, int r, int t) {
//        System.out.println(a + " " + nums[l] + " " + nums[r]);
        List<List<Integer>> resList = new ArrayList<>();
        int[] res = new int[]{-1, -1};
        while (l < r) {
            if (nums[l] + nums[r] > t) {
                r--;
            } else if (nums[l] + nums[r] < t) {
                l++;
            } else {
                List<Integer> tmpList = new ArrayList<>();
                int x = nums[l], y = nums[r];
                tmpList.add(a);
                tmpList.add(x);
                tmpList.add(y);
                resList.add(tmpList);
                while (l <= r) {
                    if (nums[l] > x) {
                        break;
                    }
                    l++;
                }
            }
        }
        return resList;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; ) {
//            for (int j = i + 1, k = nums.length - 1; j < k; ) {
//                if (nums[i] + nums[j] + nums[k] > 0) { --k; }
//                else if (nums[i] + nums[j] + nums[k] < 0) { ++j; }
//                else {
//                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
//                    int m = j + 1;
//                    while (m < k && nums[j] == nums[m]) { ++m; }
//                    j = m;
//                }
//            }
//            int m = i + 1;
//            while (m < nums.length - 2 && nums[i] == nums[m]) { ++m; }
//            i = m;
//        }
//        return ans;
//    }
}
