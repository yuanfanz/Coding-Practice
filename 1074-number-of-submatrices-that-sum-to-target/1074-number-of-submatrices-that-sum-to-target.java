class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] presum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                presum[i][j] = matrix[i - 1][j - 1] + presum[i][j - 1] 
                    + presum[i - 1][j] - presum[i - 1][j - 1];
            }
        }
        int count = 0;
        for (int top = 1; top <= m; ++top) {
            for (int bottom = top; bottom <= m; ++bottom) {
                int area = 0;
                // key is area, value is frequency for this area
                Map<Integer, Integer> map = new HashMap<>();
                // map.put(0, 1);
                // calculating presum of areas
                for (int col = 1; col <= n; ++col) {
                    area = presum[bottom][col] - presum[top - 1][col];
                    if (area == target) count++;
                    if (map.containsKey(area - target)) {
                        count += map.get(area - target);
                    }
                    map.put(area, map.getOrDefault(area, 0) + 1);
                }
            }
        }
        return count;
    }
}