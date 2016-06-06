package teisei.algo.bop;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/4/23.
 */
public class P1 {
    public static void main(String[] args) {
        float[] a = new float[]{7.5398f, 6.5398f, 1f, 1f};
        a = new float[]{-6.5f, -8.9f, 10.3f, -8.9f};
        int[] rse = Puzzle(a);
        for (int e : rse) {
            System.out.println(e);
        }
    }

    public static int[] Puzzle(float[] a) {
        float[] b = new float[a.length];
        for(int i=0;i<a.length;i++)
            b[i] = a[i];
        Arrays.sort(b);
        int[] res = new int[a.length];
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<b.length;j++) {
                if (b[j] == a[i]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
