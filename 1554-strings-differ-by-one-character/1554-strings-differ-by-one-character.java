class Solution {
    public boolean differByOne(String[] dict) {
        long mod = (long) Math.pow(10, 20) + 7;
        
        int n = dict[0].length();
        long[] prehash = new long[dict.length];
        for (int i = 0; i < dict.length; ++i) {
            for (int j = 0; j < n; ++j) {
                prehash[i] = (prehash[i] * 26 + dict[i].charAt(j) - 'a') % mod;
            }
        }
        
        long base = 1L;
        Set<Long> set = new HashSet<>();
        for (int j = n - 1; j >= 0; --j) {
            set.clear();
            for (int i = 0; i < dict.length; ++i) {
                long newHash = (prehash[i] - base * (dict[i].charAt(j) - 'a')) % mod;
                if (!set.add(newHash)) return true;
            }
            base = 26 * base % mod;
        }
        return false;
    }
}


















