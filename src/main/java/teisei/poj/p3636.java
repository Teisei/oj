package teisei.poj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/5.
 */

class Doll implements Comparable<Doll> {
    int w, h;

    public Doll(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "(" + w + "," + h + ")";
    }

    @Override
    public int compareTo(Doll o2) {
        if (this.w < o2.w && this.h < o2.h) return -1;
        if (this.w > o2.w && this.h > o2.h) return 1;
        return 0;
    }
}

/**
 * 相同的方法，C++过了。
 */
public class p3636 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int m = sc.nextInt();
            Doll[] dolls = new Doll[m];
            for (int i = 0; i < m; i++) {
                int w = sc.nextInt();
                int h = sc.nextInt();
                dolls[i] = new Doll(w, h);
            }
            Arrays.sort(dolls);
            List<Doll> dollList = Arrays.asList(dolls);

            List<Doll> resList = new ArrayList<Doll>();

            for (Doll doll : dollList) {
                boolean flag = false;
                for (int i = 0; i < resList.size(); i++) {
                    Doll tmpDoll = resList.get(i);
                    if (tmpDoll.compareTo(doll) < 0) {
                        resList.remove(i);
                        resList.add(i, doll);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    resList.add(doll);
                }
            }
            System.out.println(resList.size());
        }
        System.out.println();
    }
}