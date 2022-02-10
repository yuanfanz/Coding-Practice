class Solution {
    public boolean checkValid(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; ++i){
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < n;++j) {
                if (!row.add(matrix[i][j]) || !col.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }
}