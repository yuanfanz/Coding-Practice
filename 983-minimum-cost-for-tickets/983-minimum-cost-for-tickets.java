class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int firstDay = days[0];
        int lastDay = days[n - 1];
        int[] dp = new int[lastDay + 31];
        int ptr = n - 1;
        for (int i = lastDay; i >= firstDay; --i) {
            if (i == days[ptr]) { // means we are gonna travel this day
                // three choices
                // buy x-day pass means we pay for current pass cost
                // and we pay the cost after x-day pass expires
                dp[i] = Math.min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]);
                dp[i] = Math.min(dp[i], dp[i + 30] + costs[2]);
                ptr--;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[firstDay];
    }
}