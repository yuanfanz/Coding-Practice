class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        
        s0[0] = -prices[0];
        s1[0] = 0;
        
        for (int i = 1; i < n; ++i) {
            s0[i] = Math.max(s0[i - 1], s1[i - 1] - prices[i]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] + prices[i] - fee);
        }
        return Math.max(s0[n - 1], s1[n - 1]);
    }
}