class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[] prev = new long[n];
        int index = 0;
        for (int i : points[0]) {
            prev[index++] = i;
        }
        for (int i = 0; i < m - 1; ++i) {
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = prev[0];
            right[n - 1] = prev[n - 1];
            
            for (int j = 1; j < n; ++j) {
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            }
            for (int j = n - 2; j >= 0; --j) {
                right[j] = Math.max(right[j + 1] - 1, prev[j]);
            }
            long[] cur = new long[n];
            for (int j = 0; j < n; ++j) {
                cur[j] = points[i + 1][j] + Math.max(left[j], right[j]);
            }
            prev = cur;
        }
        long res = 0;
        for (long i : prev) {
            res = Math.max(res, i);
        }
        return res;
    }
}