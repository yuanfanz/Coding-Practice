class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] dir = new int[]{0,1,0,-1,0};
        int[][] indegree = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < dir.length - 1; ++k) {
                    int row = i + dir[k];
                    int col = j + dir[k + 1];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    if (matrix[row][col] > matrix[i][j]) {
                        indegree[row][col]++;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (indegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int len = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                for (int k = 0; k < dir.length - 1; ++k) {
                    int row = cur[0] + dir[k];
                    int col = cur[1] + dir[k + 1];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    if (matrix[row][col] > matrix[cur[0]][cur[1]]) {
                        indegree[row][col]--;
                        if (indegree[row][col] == 0) {
                            queue.offer(new int[]{row, col});
                        }
                    }
                }
            }
            len++;
        }
        return len;
    }
}















