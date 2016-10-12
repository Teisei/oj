public class P_28_Search2D_Metrix {
    /**

	Problem:
	Write an efficient algorithm that searches for a value in an m x n matrix.
	This matrix has the following properties:
	1) Integers in each row are sorted from left to right.
	2) The first integer of each row is greater than the last integer of the previous row.

	Constraints:
	1) matrix: m rows, n columns, 0<= n, m <= ??
	2) sorted in the order [0,0], [0,1], ..., [m-1, n-1]
	3) return if a given value in the matrix,
		true or false

	Ideas:
	1) brute force
	time: O(n ^ 2)
	space: O(1)

	2) divide and conquer(binary serach)
	access the matrix like an array:
		1. location(i, j) => index = i * n + j
		2. index => x = index/n; y = index%n


     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		int m = matrix.length, n = matrix[0].length;
		int l = 0, r = m * n - 1;
		while(l <= r){
			int mid = (r - l) / 2 + l;
			int x = mid / n, y = mid % n;
			if(matrix[x][y] == target) return true;
			else if(matrix[x][y] < target) l = mid + 1;
			else r = mid - 1;
		}
		return false;
    }
}
