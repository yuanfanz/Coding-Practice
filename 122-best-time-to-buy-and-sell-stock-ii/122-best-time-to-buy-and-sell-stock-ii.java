class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        
        int[] diff = new int[n];
        for (int i = 1; i < n; ++i) {
            diff[i] = prices[i] - prices[i - 1];
        }
        for (int i = 0; i < n; ++i) {
            max += Math.max(diff[i], 0);
        }
        return max;
    }
}