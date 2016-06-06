package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/5/29.
 */
public class p_50_Pow_x_n {
    public static void main(String[] args) {
        new p_50_Pow_x_n().run();
    }

    public void run() {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }

    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == -1) return (n%2==0)?1:0;

        if(n==0) return 1;
        else if(n<0){
            x = 1/x;
            n *= -1;
        }

        double res = 1;
        for(int i=0;i<n;i++){
            res *= x;
            if(res==0) break;
        }
        return res;
    }
}
