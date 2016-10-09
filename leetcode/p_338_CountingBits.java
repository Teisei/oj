package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/5/28.
 */
public class p_338_CountingBits {
    public static void main(String[] args) {
        new p_338_CountingBits().run();
    }

    public void run() {
        int num = 2;
        int[] ints = countBits(2);
        for (int x : ints) {
            System.out.println(x);
        }
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        int i = 0;
        int x = 1;
        while (x <= num) {
            int u = p2(i), v = p2(i + 1);
            x = u;
            while (x < v && x <= num) {
                res[x] = 1 + res[x - u];
                x++;
            }
            i++;
        }
        return res;
    }

    public int p2(int i) {
        if (i == 0) return 1;
        return 2 * p2(i - 1);
    }
}
