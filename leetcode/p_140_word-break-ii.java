public class p_140_word-break-ii {
	/**
		Problem:
		Given a string s and a dictionary of words dict,
		add spaces in s to construct a sentence
		where each word is a valid dictionary word.
		Return all such possible sentences.

		Example,
		s = "catsanddog", dict=["cat", "cats", "and", "sand", "dog"]
		=> ["cats and dog", "cat sand dog"]

		Constraints:
		1) s: a string, 0 <= length <= N
		2) dict: a set of words, each word is a string, 1 <= len <= K
		3) output: all possible sentences

		Idea:
		1) DFS
		search starts from the start of the string,
		for each possible word, length from 1 to k, go to step out,
		and then recursively do this, if we find the search points to the end,
		output the current status to the output.
		time: ex
		space: ex

		2) dynamic programming
		dp1[i] is a list containing k words and ends at i th position,
		for every position i, for every word in dict, check if it can be contained ending at position i.
		dp2[i] is how many possible sentences that ends at i th position,
		so dp2[i] = sum(dp1[j] * dp2[j - word[j].length] for j in [0, k))
		time: O(n * k)
		space: O(n * k)

	*/
	public List<String> wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0) return null;

		int max_len = 0;
		for (String w: wordDict) {
			max_len = Math.max(max_len, w.length());
		}

		int N = s.length();
		List<String> dp[] = new ArrayList[N];
		for (int j = 0; j < N; j ++) {
		    dp[j] = new ArrayList<String>();
			for (int i = j; j - i + 1 <= max_len && i >= 0; i --) {
				String w = s.substring(i, j + 1);
				if (wordDict.contains(w)) {
					dp[j].add(w);
				}
			}
		}

        List<String> res[] = new ArrayList[N];
        dfs(res, dp, wordDict, N);
		return res[N - 1];
	}
	private void dfs(List<String> res[], List<String> dp[], Set<String> wordDict, int end) {
	    if (end  == 0 || res[end - 1] != null) {
	        return;
	    }
	    // solve res[j]
	    int j = end - 1;
	    res[j] = new ArrayList<String>();
	    for (String w1: dp[j]) {
	        int i = j - w1.length() + 1;
	        if (i == 0) {
	            res[j].add(w1);
	        } else {
	            dfs(res, dp, wordDict, i);
    	        for (String w0: res[i - 1]) {
    	            res[j].add(w0 + " " + w1);
    	        }
	        }
	    }
	}
}
