class Solution {
    public long getDescentPeriods(int[] prices) {
        
        int n = prices.length;
        long res = n;
        int cur = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i - 1] == prices[i] + 1) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}