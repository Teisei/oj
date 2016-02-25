package teisei.leetcode;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/2/25.
 */
public class p_16_3SumClosest {
    public static void main(String[] args) {
        p_16_3SumClosest test = new p_16_3SumClosest();
        test.run();
    }

    public void run() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        // Map<Integer, List<Integer>> resMap = new HashMap<>();
        Arrays.sort(nums);
        int chax_total = Integer.MAX_VALUE;
        int x_total = -1;
        for(int i=0;i<nums.length-2;i++){
            int chax = Integer.MAX_VALUE;
            int x = -1, a=-1,c=-1,b=-1;
            for(int j=i+1, k=nums.length-1;j<k && chax>0;){
                int chax_tmp = Math.abs(nums[i]+nums[j]+nums[k]-target);
                if(chax_tmp<chax){
                    chax = chax_tmp;
                    x = nums[i] + nums[j] + nums[k];
                    a=i; b=j;c=k;
                }
                if(nums[i]+nums[j]+nums[k]>target) k--;
                else if(nums[i]+nums[j]+nums[k]<target) j++;
                else{
                    k--;j++;
                }

            }
            if (chax < chax_total) {
                chax_total = chax;
                x_total = x;
            }
            // List<Integer> tmpList = new ArrayList<>();
            // tmpList.add(a);
            // tmpList.add(b);
            // tmpList.add(c);
            // resMap.put(chax, tmpList);
        }
        // int chax = Integer.Max_int;
        // List<Integer> tmpList = new ArrayList<>();
        // for(int c = resMap.keys()){
        //     if(c<chax){
        //         chax = c;
        //         tmpList = resMap.get(c);
        //     }
        // }
        return x_total;
    }
}
