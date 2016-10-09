package teisei.algo.leetcode;

import java.util.*;
/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Main:
 * Given nums1 = [1,2,2,1], nums2 = [2,2], return [2,2]
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 */

/**
 * Created by Teisei on 2016/5/25.
 */
public class p_350_IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        new p_350_IntersectionOfTwoArraysII().run();
    }

    public void run() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{1, 1};
        int[] res = intersection1(nums1, nums2);
    }

    /**
     * Naive solution:
     * First sort the two arrays;
     * Create two points pointing to the head of the two arrays;
     * Compare the number the two points pointing to,
     * If find two equal value, both two points move next;
     * Else move the little one next.
     *
     * After one of the points point to the tail of the relative array, we stop the algorithm.
     *
     * Complexity:
     * O(NlogN + MlogM + M+N)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        i = 0;
        for (int x : list) {
            res[i++] = x;
        }
        return res;
    }

    /**
     * put element with number from nums1 into a hashmap,
     * for each of the element of nums2,
     *
     * O(N + M)
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            int[] tmp = nums2;
//            nums2 = nums1;
//            nums1 = tmp;
//        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            if(!map.containsKey(x)) map.put(x, 1);
            else map.put(x, map.get(x) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int y : nums2) {
            if(map.containsKey(y)){
                if (map.get(y) > 0) {
                    list.add(y);
                    map.put(y, map.get(y) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int x : list) {
            res[i++] = x;
        }
        return res;
    }

    private int findLeftMostEqual(int[] nums, int s, int t, int target) {
        while (s < t) {
            int mid = (t - s) / 2 + s;
            mid += (t % 2 == s % 2) ? 0 : 1;
            if (nums[mid] <= target) {
                s = mid;
            } else {
                t = mid - 1;
            }
        }
        if(nums[s] == target) return s;
        return -1;
    }

    /**
     * follow up: what if the given array is already sorted?
     *
     * if one of the arrays is sorted, Complextity = O(NlogN + N+M)
     * if both of the arrays are sorted, Complexity = O(N+M)
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        return new int[]{};
    }

    /**
     * follow up: What if nums1's size is small compared to num2's size? Which algorithm is better?
     *
     * Algorithm:
     * 1) sort nums1;
     * if one of the arrays is sorted, Complextity = O(NlogN + N+M)
     * if both of the arrays are sorted, Complexity = O(N+M)
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        return new int[]{};
    }
}
