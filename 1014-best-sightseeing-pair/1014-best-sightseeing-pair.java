class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int presum = values[0];
        
        int max = values[0];
        for (int i = 1; i < values.length; ++i) {
            max = Math.max(max, presum + values[i] - i);
            presum = Math.max(presum, values[i] + i);
        }
        return max;
    }
}