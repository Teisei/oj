package teisei.algo.lint.bigcompany.lv2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Teisei on 2016/4/24.
 */
public class P2 {
    public static void main(String[] args) {
        new P2().run();
    }

    public void run() {
        int[] nums = new int[]{-78, -50, 18, -93, -35, -31, -21, -14, -73, -38, -77, 14, -80, -62, 5, -36, -67, -51, 24, -48, -64, -75, 42, -38, -56, -49, 2, -11, -98, -34, -13, -75, -42, -47, -99, -82, -34, -34, 10, -94, -12, -67, -75, -88, -20, -98, 22, -82, 46, 4, -93, 30, -45, -1, 32, 43, -73, -2, -3, -58, 19, -89, -54, -62, -47, 12, 2, -20, -6, -41, -89, -89, 28, -91, 28, 7, 8, -47, -37, -4, 27, 44, 19, -13, -2, -85, -75, -80, -81, 36, -30, 46, 8, -53, 24, 41, -16, 41, 45, -35, 8, -78, 39, -97, 14, -73, 37, 47, 36, -42, -89, -96, 10, -69, 35, -83, -50, 47, 26, -27, -76, -28, -42, 9, 17, -86, -57, 27, 44, 4, -54, -80, 45, -53, 49, -36, -56, 13, -19, -57, 16, -31, -42, 31, -53, -17, 24, 35, -52, -4, -85, -22, -14, -2, -97, -45, -6, -47, -81, -76, -35, -16, -46, -97, -32, -57, -4, -41, -41, -34, 5, -2, -65, 25, 16, 40, -90, 19, 13, -53, 30, -50, 7, -30, -14, -10, 18, -65, 50, 42, -48, 27, 15, -66, -65, -48, -35, -36, -8, 16, 41, -45, -65, -77, 30, -4, 2, -57, -92, 10, -41, 44, -55, -68, -98, 23, -79, 18, -99, -60, 44, 39, -55, -35, -18, 47, -40, -37, 35, 45, -57, -52, -55, -58, -93, -25, -81, -14, 44, 29, 0, -71, 45, -71, -56, -2, -61, 12, -96, -16, 50, -17, -73, -29, -38, 41, -68, -43, -50, -98, 43, 0, -48, -95, 15, -48, -87, -4, 39, -72, 8, -66, -75, -95, -51, 28, -36, -90, 37, -59, -60, 30, -80, -30, 21, -44, 15};
        nums = new int[]{-7, 1, 2, -3, 4, 3};
        ArrayList<Integer> resList = subarraySum2(nums);
        for (int e : resList) {
            System.out.println(e);
        }
    }


    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> resList = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        for(int len=1;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                //start from i
                if(len==1){
                    dp[i] = nums[i];
                } else{
                    dp[i] = dp[i] + nums[i+len-1];
                }
                if(dp[i]==0){
                    resList.add(i);
                    resList.add(i+len-1);
                    return resList;
                }
            }
        }
        return resList;
    }

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum2(int[] nums) {
        // write your code here
        int numslen = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for(int i=0;i<numslen;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                System.out.println(sum);
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            map.put(sum,i);
        }
        return result;
    }
}
