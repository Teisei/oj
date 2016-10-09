package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/6/4.
 */
public class p_75_SortColors {
    public static void main(String[] args) {
        new p_75_SortColors().run();
    }

    public void run() {
        int[] nums = new int[]{0, 2, 1};
        printList(nums);
        sortColors(nums);
        printList(nums);
    }

    public void sortColors(int[] nums) {
        int N = nums.length;
        int s = 0, t = N - 1, i = 0;
        int tmp;
        while (i >= s && i <= t) {
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[s];
                nums[s++] = tmp;
                i = Math.max(s, i);
            } else if (nums[i] == 2) {
                tmp = nums[i];
                nums[i] = nums[t];
                nums[t--] = tmp;
                i = Math.min(t, i);
            } else {
                i++;
            }
        }
    }

    private void printList(int[] nums) {
        for (int x : nums) {
            System.out.print(x + "\t");
        }
        System.out.println();
    }

}
