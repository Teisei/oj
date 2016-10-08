package teisei.algo.hiho.mstest2015july1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/6.
 */
public class pA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        List<Integer> list1 = getDivisors(P);
        List<Integer> list2 = getDivisors(Q);
        for (int x : list1) {
            for (int y : list2) {
                System.out.println(x + " " + y);
            }
        }
    }

    public static List<Integer> getDivisors(int x) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            if(x%i==0) resList.add(i);
        }
        return resList;
    }
}
