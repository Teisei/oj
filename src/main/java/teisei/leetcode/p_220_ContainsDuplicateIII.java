package teisei.leetcode;

/**
 * Created by Teisei on 2016/3/11.
 */
public class p_220_ContainsDuplicateIII {
    public static void main(String[] args) {
        p_220_ContainsDuplicateIII test = new p_220_ContainsDuplicateIII();
        test.run();
    }

    public void run() {
        int nums[] = new int[]{
                -1, -1
        };
        System.out.println(containsNearbyAlmostDuplicate(nums, 10000, 0));
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=Math.min(nums.length-1, i+k);j++){
                if(Math.abs(nums[i]-nums[j])<=t)
                    return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=Math.min(nums.length-1, i+k);j++){
                if(Math.abs(nums[i]-nums[j])<=t)
                    return true;
            }
        }
        return false;
    }
}
