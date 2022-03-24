class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[m][n];
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (queue.size() != 0) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                   || visited[row][col]) continue;
                visited[row][col] = true;
                distance[row][col] = distance[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{row, col});
            }
        }
        return distance;
    }
}