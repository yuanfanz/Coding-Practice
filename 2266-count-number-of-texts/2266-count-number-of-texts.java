class Solution {
    public int countTexts(String s) {
        int mod = (int) Math.pow(10, 9) + 7;
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Integer> fourset = new HashSet<>();
        fourset.add(7);
        fourset.add(9);
        
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int num = s.charAt(i - 1) - '0';
            int count = 3;
            if (fourset.contains(num)) {
                count = 4;
            }
            
            if (s.charAt(i - 1) != s.charAt(i - 2)) {
                dp[i] = dp[i - 1];
            } else {
                int dup = 2;
                dp[i] += dp[i - 1];
                if (count == 4) {
                    if (i - 3 >= 0 && s.charAt(i - 1) == s.charAt(i - 3)) {
                        dp[i] += dp[i - 2];
                        dup++;
                        if (i - 4 >= 0 && s.charAt(i - 1) == s.charAt(i - 4)) {
                            dp[i] += dp[i - 3];
                            dup++;
                        }
                    }
                } else {
                    if (i - 3 >= 0 && s.charAt(i - 1) == s.charAt(i - 3)) {
                        dp[i] += dp[i - 2];
                        dup++;
                    }
                }
                dp[i] += dp[i - dup];
                dp[i] %= mod;
            }
        }
        return (int) (dp[n] % mod);
    }
}