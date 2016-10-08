package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/3/15.
 */
public class p_27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int p = 0, t = 0;
        while(t<nums.length){
            if(nums[t]!=val){
                nums[p++]=nums[t];
            }
            t++;
        }
        return p;
    }
}
