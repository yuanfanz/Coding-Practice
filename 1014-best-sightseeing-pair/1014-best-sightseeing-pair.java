class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int max = values[0];
        int sum = values[0];
        for (int i = 1; i < values.length; ++i) {
            max = Math.max(max, sum + values[i] - i);
            sum = Math.max(sum, values[i] + i);
        }
        return max;
    }
}