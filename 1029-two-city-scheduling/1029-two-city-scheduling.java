class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        
        int n = costs.length;
        for (int[] cur : costs) {
            sum += cur[0];
        }
        int[] refund = new int[n];
        for (int i = 0; i < n; ++i) {
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < n / 2; ++i) {
            sum += refund[i];
        }
        return sum;
    }
}