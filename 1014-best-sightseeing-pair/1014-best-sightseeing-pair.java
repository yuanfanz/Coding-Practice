class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxSoFar = values[0];
        int res = 0;
        for (int i = 1; i < values.length; ++i) {
            res = Math.max(res, maxSoFar + values[i] - i);
            maxSoFar = Math.max(maxSoFar, values[i] + i);
        }
        return res;
    }
}