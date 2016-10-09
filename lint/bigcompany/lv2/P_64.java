class Solution {
    /**
	Problem:
	Given two sorted integer arrays A and B, merge B into A as one sorted array.
	Notice:
	You may assume that A has enough space (size that is greater or equal to m + n)
	to hold additional elements from B.
	The number of elements initialized in A and B are m and n respectively.

	Idea:
	1) set two pointers to the tail of A and B,
	compare and get the larger one to the tail of array A
	time: O(n + m)
	space: O(1)

	
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     *
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
		if(A == null || B == null){
			A = A==null?B:A;
			return;
		}
		int tail1 = m - 1, tail2 = n - 1, tail = m + n - 1;
		while(tail >= 0){
			if(tail1 < 0){
				A[tail--] = B[tail2--];
			}else if(tail2 < 0){
				A[tail--] = A[tail1--];
			}else{
				if(A[tail1] >= B[tail2]){
					A[tail--] = A[tail1--];
				}else{
					A[tail--] = B[tail2--];
				}
			}
		}
    }
}
