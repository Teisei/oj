public class Solution {
	/**
		Problem:
		Given a string s and a dictionary of words dict,
		determine if s can be segmented into
		a space-separated sequence of one or more dictionary words.

		Example,
		s="leetcode";dict=["leet", "code"]. => true

		Constraints:
		1) s, string, 0<= length <= N
		2) a set of words, each word is a string with length: 1 <= len <= K
		3) output: whether a string can be segmented

		Idea:
		1) dp
		dp[i] = true, means if s[0, i] can be segmented
		then dp[i] = true if at least one s[i-j, i] in dict && ( dp[i-j-1]=true || i-j == 0)
					for j in [0, k)
		termination: check if dp[N-1] = true
		time: O(n * k)
		space: O(1)

		Follow up: What if size of the dictionary is very large
		Follow up: what do you think the length of the string?
		
	*/
	public boolean wordBreak(String s, Set<String> wordDict) {
		int N = s.length();
		int M = wordDict.size();
		int k = 0;
		for(String w: wordDict) {
			k = Math.max(w.length(), k);
		}

		boolean[] dp = new boolean[N];
		for(int i = 0; i < N; i ++) {
			for(int l = 1; l <= k && i - l >= -1; l ++) {
				boolean flag = true;
				String w = s.substring(i - l + 1, l);
				flag = wordDict.contains(w);
				if(i - l > -1 && flag) {
					flag = dp[i - l];
				}
				if(flag) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[N - 1];
	}
}
