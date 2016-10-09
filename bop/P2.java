package teisei.algo.bop;

import java.util.Arrays;

/**
 * Created by Teisei on 2016/4/23.
 */
public class P2 {
    public static void main(String[] args) {
        int[] a = new int[]{1};
        a = new int[]{3, 4, 5, 6};//4
        a = new int[]{4, 14, 7};//7
//        a = new int[]{1};//1
//        a = new int[]{1, 1};//1
//        a = new int[]{1, 1, 1};//1
//        a = new int[]{1, 1, 1, 1};//1
//        a = new int[]{2};//2
//        a = new int[]{10, 5};//7
        a = new int[]{6, 9};//7
//        a = new int[]{1, 3};//1
        a = new int[]{2, 1};//1
        a = new int[]{3, 1};//1


        System.out.println(Puzzle(a));
    }

    public static int Puzzle(int[] a) {
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++)
            b[i] = a[i];
        Arrays.sort(a);
        int len = a.length;
        int left = (len % 2 == 0) ? (len / 2 - 1) : len / 2;
        int right = (len % 2 == 0) ? len / 2 : len / 2;
        int mid = (a[left] + a[right]) / 2;
        int haha = a[(left + right) / 2];
        return mid;
    }
}
