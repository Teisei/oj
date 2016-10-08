package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/21.
 */
public class p_11_ContainerWithMostWater {
    public static void main(String[] args) {
        p_11_ContainerWithMostWater test = new p_11_ContainerWithMostWater();
        test.run();

    }
    public void run() {
        int height[] = {1,1};
        System.out.println(maxArea(height));

    }

    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max(res, getArea(left, height[left], right, height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                if (i != j) {
//                    res = Math.max(res, getArea(i, height[i], j, height[j]));
//                }
//            }
//        }
        return res;
    }

    public int getArea(int i, int hi, int j, int hj) {
        int h = Math.min(hi, hj);
        return (j - i) * h;
    }
}
