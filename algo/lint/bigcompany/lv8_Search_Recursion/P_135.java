public class Solution {
    /**

	Problem:
	Given a set of candidate numbers (C) and a target number (T),
	find all unique combinations in C where the candidate numbers sums to T.
	The same repeated number may be chosen from C unlimited number of times.

	Constraints:
	1) a set of candidate numbers, 0<= length
	2) elements: 0 < X <= INT_MAX
		target: INT_MIN <= t <= INT_MAX
	3) contain deplicates? yes
	4）output: combinations, should be in non-descending order

	Test case:
	[3, 3, 1], 4 => [[1,1,1,1], [1,3]]

	Idea:
	1) similar as all combination,
	except a number can be selected multiple times
	time: exponetial
	space: same

     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
		List<List<Integer>> resList = new ArrayList<>();
		if(candidates == null || candidates.length == 0) return resList;

		Arrays.sort(candidates);
		List<Integer> path = new ArrayList<>();
		int sum = 0, curr = 0;
		for(int i = 0; i < candidates.length; i ++){
			if(i == 0 || candidates[i]!=candidates[i-1])
				dfs(resList, candidates, path, sum, target, i);
		}
		return resList;
    }
	public void dfs(List<List<Integer>> resList, int[] candidates,
		List<Integer> path, int sum, int target, int curr){
		// add the curr th element and check the sum
		if(curr >= candidates.length) return;
		int x = candidates[curr];
		path.add(x);
		sum += x;
		if(sum == target){
			resList.add(new ArrayList<Integer>(path));
		}else if(sum < target){
			for(int i = curr; i < candidates.length; i ++){
				if(i == 0 || candidates[i]!=candidates[i-1])
					dfs(resList, candidates, path, sum, target, i);
			}
		}else{
			//pass
		}
		path.remove(path.size() - 1);
	}
}
