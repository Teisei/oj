public class P_152 {
    /**
		Problem:
		Given two integers n and k, return all possible combinations of k numbers out of 1 ... n

		Constraints:
		1) n numbers 1,2,3,...,n
		2) combination of k numbers: choose k numbers
		3) return the all combinations

		Test case:
		n = 4, k = 2
		=> [[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]

		Idea:
		return all combinations, traverse all
		1) brute force, check all combinations if it is of size k
		time: O(2^n * n)
		space: O(k * k^2)

		2) put n numbers in an sorted array, [1, 2, ..., n]
		divide it into two parts, [1,2,..,s-1], [s,..,n]
		and we have a selected list of choose numbers, with length x,
		and we need to select the left (k-x) numbers in the right sub array
		for every number, we can choose select or not to select
		branch cutting: if the list if already k,
						if the right subarray is not enough
		time: O(k * k^2)
		space: O(k * k^2)
     *
      * @param n: Given the range of numbers
      * @param k: Given the numbers of combinations
      * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
		List<List<Integer>> resList = new ArrayList<>();
		if(n < 1 || n < k) return resList;

		List<Integer> path = new ArrayList<>();
		int s = 1;
		dfs(resList, path, s, k, n);
		return resList;
    }
	public void dfs(List<List<Integer>> resList,
		List<Integer> path, int s, int k, int n){
		if(path.size() == k){
			resList.add(new ArrayList<Integer>(path));
			return;
		}
		if(path.size() + n - s + 1 < k || s == n + 1){
			return;
		}
		// choose to select s or not
		dfs(resList, path, s + 1, k, n);
		path.add(s);
		dfs(resList, path, s + 1, k, n);
	}
};
