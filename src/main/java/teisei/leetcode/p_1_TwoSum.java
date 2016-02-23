package teisei.leetcode;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/2/23.
 */
public class p_1_TwoSum {
    public static void main(String[] args) {
        p_1_TwoSum test = new p_1_TwoSum();
        test.run();
    }

    public void run() {
        int[] nums = {5, 4, 15};
        int target = 19;
        int[] res = twoSum(nums, target);
        for (int a : res) {
            System.out.println(a);
        }
    }

    public int[] twoSum(int[] nums, int target){
        int inx = 0;
        int[] result = {0,0};
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(nums);
        //Sort and find the largest match number
        while(result[1]<nums.length-1&&nums[result[1]]+nums[0]<target){
            result[1]++;
        }
        while(result[0]<result[1]){
            System.out.println("************ " + result[0]+"="+nums[result[0]] + "   " + result[1]+"="+nums[result[1]]);
            while(result[0]<result[1]&&nums[result[0]]+nums[result[1]]>target){
                System.out.println("111 "+inx++);

                result[1]--;
            }
            while(result[0]<result[1]&&nums[result[0]]+nums[result[1]]<target){
                System.out.println("222 "+inx++);
                result[0]++;
            }
            if(nums[result[0]]+nums[result[1]]==target){
                break;
            }
        }
        int i;
        for(i=0;i<nums.length&&copy[i]!=nums[result[0]];i++){}
        result[0]=i;
        for(i=nums.length-1;i>=0&&copy[i]!=nums[result[1]];i--){}
        result[1]=i;
        return result;

    }
}
