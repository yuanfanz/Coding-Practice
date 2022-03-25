class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        
        int maxSoFar = values[0];
        int score = values[0];
        for (int i = 1; i < n; ++i) {
            score = Math.max(score, maxSoFar + values[i] - i);
            maxSoFar = Math.max(maxSoFar, values[i] + i);
        }
        return score;
    }
}