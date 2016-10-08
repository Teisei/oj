package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/5/31.
 */
public class p_4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        new p_4_MedianOfTwoSortedArrays().run();
    }

    public void run() {
        int[] A = new int[]{1};
        int[] B = new int[]{2, 3, 4, 5, 6};
        System.out.println(findMedianSortedArrays(A, B));
    }


    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null) {
            return 0;
        }
        int len = A.length + B.length;
        int mid1 = (len + 1) / 2;
        int mid2 = len / 2 + 1;
        // there are chances the mid1 == mid2, (i.e. when odd elements)
        // for simplicity of the code, leave it this way. I admit I'm lazy.
        double x1 = (double) getKth(A, B, mid1);
        double x2 = (double) getKth(A, B, mid2);
        return (double) (x1 + x2) / 2;
    }

    private int getKth(int A[], int B[], int k) {

        int N = A.length, M = B.length;
        int s1 = 0, s2 = 0, t1, t2;

        while (k > 1 && s1 < N && s2 < M) {
            int l = k / 2;
            t1 = s1 + l - 1;
            t1 = Math.min(t1, N - 1);
            t2 = s2 + l - 1;
            t2 = Math.min(t2, M - 1);
            if (A[t1] <= B[t2]) {
                //abondom A[s1-t1]
                k -= t1 - s1 + 1;
                s1 = t1 + 1;
            } else {
                //abondom B[s2-t2]
                k -= t2 - s2 + 1;
                s2 = t2 + 1;
            }
        }
        if (s1 < N && s2 < M) return Math.min(A[s1], B[s2]);
        else if (s1 < N) return A[s1 + k - 1];
        else return B[s2 + k - 1];
    }
}
