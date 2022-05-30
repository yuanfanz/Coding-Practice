class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cool = new int[n];
        
        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        cool[0] = 0;
        
        for (int i = 1; i < n; ++i) {
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            sell[i] = buy[i - 1] + prices[i];
            cool[i] = Math.max(cool[i - 1], sell[i - 1]);
        }
        return Math.max(cool[n - 1], sell[n - 1]);
    }
}