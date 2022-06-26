class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i = 0;
        int sum = 0;
        int n = cardPoints.length;
        int len = 0;
        int min = Integer.MAX_VALUE;
        int total = 0;
        int limit = n - k;
        for (int j = 0; j < n; ++j) {
            sum += cardPoints[j];
            total += cardPoints[j];
            len++;
            while (i < n && len > limit) {
                sum -= cardPoints[i++];
                len--;
            }
            if (len == limit) {
                min = Math.min(min, sum);
            }
        }
        return total - min;
    }
}