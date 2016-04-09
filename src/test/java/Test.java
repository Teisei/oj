//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


class IntTriple {
    int k;
    int x;
    int y;

    public IntTriple(int k, IntTuple tuple) {
        this.k = k;
        this.x = tuple.x;
        this.y = tuple.y;
    }

    public String toString() {
        return "(" + this.k + ", " + this.x + ", " + this.y + ")";
    }
}

//

class IntTuple {
    int x;
    int y;

    public IntTuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    public void run() {
        int[] a = new int[]{1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9};
        a = new int[]{2, 2, 2, 2, 2, 2, 2};
        a = new int[]{1, 0, -1, -1, -1, -1, 0, 1, 1, 1};
        a = new int[]{-8, 0, -7, -101, -123, -1, -2, 0, -1, 0, -1111, 0, -1, -2, -3, -4, -5, -6, -100, -98, -111, -11};
        Arrays.sort(a);

        System.out.println("****************** two sum ******************");
        System.out.println(">>>>>> single results");
        System.out.println(this.twoSum(a, 0, a.length - 1, 0));
        System.out.println(">>>>>> multiple results");
        List twolist = this.twoSumAll(a, 0, a.length - 1, 0);
        Iterator threelist = twolist.iterator();

        while(threelist.hasNext()) {
            IntTuple tuple = (IntTuple)threelist.next();
            System.out.println(tuple);
        }

        System.out.println("****************** three sum ******************");
        System.out.println(">>>>>> single results");
        System.out.println(this.threeSum(a, 0, a.length - 1, 0));
        System.out.println(">>>>>> multiple results");
        List threelist1 = this.threeSumAll(a, 0, a.length - 1, 0);
        Iterator tuple1 = threelist1.iterator();

        while(tuple1.hasNext()) {
            IntTriple triple = (IntTriple)tuple1.next();
            System.out.println(triple);
        }

        System.out.println();
    }

    public IntTuple twoSum(int[] a, int s, int t, int sum) {
        int i = s;
        int j = t;

        while(i < j) {
            if(a[i] + a[j] == sum) {
                return new IntTuple(a[i], a[j]);
            }

            if(a[i] + a[j] < sum) {
                ++i;
            } else {
                --j;
            }
        }

        return null;
    }

    public List<IntTuple> twoSumAll(int[] a, int s, int t, int sum) {
        ArrayList resList = new ArrayList();
        int i = s;
        int j = t;

        while(i < j) {

            if(a[i] + a[j] < sum)
                ++i;
            else if(a[i] + a[j] > sum)
                --j;
            else{
                resList.add(new IntTuple(a[i], a[j]));

                while(i<j){
                    i++;
                    if(a[i]>a[i-1]) break;
                }
            }
        }

        return resList;
    }

    public IntTriple threeSum(int[] a, int s, int t, int sum) {
        for(int k = s; k <= t - 2; ++k) {
            int x = sum - a[k];
            IntTuple tuple = this.twoSum(a, k + 1, t, x);
            if(tuple != null) {
                return new IntTriple(a[k], tuple);
            }

        }

        return null;
    }

    public List<IntTriple> threeSumAll(int[] a, int s, int t, int sum) {
        ArrayList resList = new ArrayList();

        for(int k = s; k <= t - 2; ++k) {
            int x = sum - a[k];
            List<IntTuple> tupleList = this.twoSumAll(a, k + 1, t, x);
            for (IntTuple tuple : tupleList) {
                resList.add(new IntTriple(a[k], tuple));
            }
            while(k<=t-2){
                if(a[k+1]==a[k]) k++;
                else break;
            }
        }
        return resList;
    }
}
