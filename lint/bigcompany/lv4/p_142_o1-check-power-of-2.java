
class Solution {
    /*
	o1-check-power-of-2

	Problem:
	Using O(1) time to check whether an integer n is a power of 2.



     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n>0 && (n & (n-1))==0){
            return true;
        }
        return false;
    }
};
