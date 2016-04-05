package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/3/15.
 */
public class p_60_PermutationSequence {
    public static void main(String[] args) {
        p_60_PermutationSequence test = new p_60_PermutationSequence();
        test.run();

    }

    public void run() {
        System.out.println(getPermutation(3, 2));

    }

    public String getPermutation(int n, int k) {
        int[] res = new int[n];
        int pos = 0;
        int[] cans = new int[n];
        for(int i=0;i<n;i++) cans[i]=i+1;
        while(n>1){
            int max_inter = haha(n-1);
            for(int i=1;i<=n;i++){
                if(k<=i*max_inter){
                    res[pos++]=cans[i-1];
                    //determin this position is
                    n-=1;
                    k-=(i-1)*max_inter;
                    cans = removeKth(cans, i-1);
                    break;
                }
            }
        }
        res[pos++] = cans[0];
        String res_Str = "";
        for(int e: res) res_Str += e;
        return res_Str;
    }
    public int haha(int n){
        if(n<2) return n;
        else return haha(n-1)*n;
    }
    public int[] removeKth(int[] cans, int k){
        int[] res = new int[cans.length-1];
        int pos=0;
        for(int i=0;i<cans.length;i++){
            if(i!=k) res[pos++]=cans[i];
        }
        return res;
    }
}
