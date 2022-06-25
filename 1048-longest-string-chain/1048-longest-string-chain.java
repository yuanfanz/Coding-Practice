class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (isValid(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        
        // System.out.println(isValid("ba", "bad"));
        
        return max;
    }
    
    private boolean isValid(String s1, String s2) {
        if (s1.length() + 1 != s2.length()) return false;
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return s1.substring(i).equals(s2.substring(j + 1));
            }
            i++;
            j++;
        }
        return true;
    }
}









