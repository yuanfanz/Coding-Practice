class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int key = i - j;
                if (map.containsKey(key)) {
                    if (map.get(key) != matrix[i][j]) {
                        return false;
                    }
                } else {
                    map.put(key, matrix[i][j]);
                }
            }
        }
        return true;
    }
}