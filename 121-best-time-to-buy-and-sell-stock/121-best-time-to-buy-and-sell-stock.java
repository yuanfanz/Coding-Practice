class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[] diff = new int[n];
        for (int i = 1; i < n; ++i) {
            diff[i] = prices[i] - prices[i - 1];
        }
        int[] presum = new int[n];
        presum[0] = diff[0];
        int max = diff[0];
        for (int i = 1; i < n; ++i) {
            presum[i] = diff[i] + (presum[i - 1] > 0 ? presum[i - 1] : 0);
            max = Math.max(max, presum[i]);
        }
        return max;
    }
}