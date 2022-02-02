class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int step = 1;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if (i == m - 1 && j == n - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n
                       || grid[row][col] == 1 || visited[row][col]) {
                        continue;
                    }
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
            step++;
        }
        return -1;
    }
}