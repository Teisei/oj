package teisei.leetcode;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/2/22.
 */
public class p_324_WiggleSort2 {
    public static void main(String[] args) {
        p_324_WiggleSort2 test = new p_324_WiggleSort2();
        test.run();

    }

    public void run() {
        int[] nums = {1, 2, 2, 2, 2, 5};
        wiggleSort(nums);
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int mid = (nums.length + 1) / 2;
        int left = mid - 1;
        int right = nums.length - 1;
        int i = 0;
        int flag = 1;
        while (left >= 0 || right >= mid) {
            if(flag == 1) {
                res[i++] = nums[left--];
            }else{
                res[i++] = nums[right--];
            }
            flag *= -1;
        }
        for (int j = 0; j < res.length; j++) {
            nums[j]=res[j];
        }
        for (int a : nums) {
            System.out.print(a + "\t");
        }
    }
}
