class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String cur : wordDict) {
            set.add(cur);
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] = dp[i] | dp[j];
                }
            }
        }
        return dp[n];
    }
}