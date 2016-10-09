package teisei.algo.lint.bigcompany.lv2;

/**
 * Created by Teisei on 2016/4/24.
 */
public class P_172 {
    public static void main(String[] args) {
        new P1().run();

    }

    public void run() {
        int[] A = new int[]{0, 4, 4, 0, 0, 2, 4, 4};
        int elem = 4;
        int res = removeElement(A, elem);
        System.out.println(res);

    }

    /**
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int i=0,j=0;
        while(i<A.length){
            if(A[i]!=elem){
                A[j++]=A[i];
            }
            i++;
        }
        return j;
    }
}
