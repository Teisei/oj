package teisei.algo.lint.bigcompany.lv2;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/4/24.
 */
public class P7 {
    public static void main(String[] args) {
        new P7().run();

    }

    public void run() {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 3;
        System.out.println(threeSumClosest(numbers, target));

    }

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here

        int n = numbers.length;

        // sort the array first
        Arrays.sort(numbers);

        int result = -1;
        int min_variation = Integer.MAX_VALUE;

        for(int i=0;i<n-2;i++){
            int first = numbers[i];
            int target_rest = target - first;
            int res = first + twoSumClosest(numbers, i+1, n-1, target_rest);
            int new_variation = target - res;
            if(Math.abs(new_variation)<Math.abs(min_variation)){
                result = res;
                min_variation = new_variation;
            }
        }
        return result;
    }
    /**
     * @param sorted_nums: Give a sorted selected array numbers of n integer, from l to r
     * @param l: the left boundary of the selected the array
     * @param r: the right boundary of the selected array
     * @param target: An integer
     * @return return the sum of the two integers, the sum closest target
     * */
    public int twoSumClosest(int[] sorted_nums, int l, int r, int target){
        int i = l, j = r;
        int result = -1;
        int min_variation = Integer.MAX_VALUE;
        while(i<j){
            int res = sorted_nums[i] + sorted_nums[j];
            int new_variation = res - target;
            if(Math.abs(new_variation) <= Math.abs(min_variation)){
                result = res;
                min_variation = new_variation;
                // closer to the target
                if(new_variation > 0) j--;
                else if(new_variation < 0) i++;
                else break;// ideal: equal the target
            } else {
                break;
            }
        }
        return result;
    }
}
