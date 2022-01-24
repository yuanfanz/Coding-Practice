class Solution {
    public boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < matrix[0].length; ++j) {
                if (!row.add(matrix[i][j]) || !col.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }
}