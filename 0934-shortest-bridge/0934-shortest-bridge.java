class Solution {
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        boolean flag = false;
        for (int i = 0; i < m; ++i) {
            if (flag) {
                break;
            }
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, dirs, queue, visited);
                    flag = true;
                    break;
                }
            }
        }
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < 0 || col < 0 || row >= grid.length
                        || col >= grid[0].length || visited[row][col]) {
                        continue;
                    }
                    if (grid[row][col] == 1) return step;
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
            step++;
        }
        return step;
    }
    private void dfs(int i, int j, int[][] grid, int[][] dirs, Queue<int[]> queue, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]) {
            return;
        }
        if (grid[i][j] == 1) {
            visited[i][j] = true;
            queue.offer(new int[]{i, j});
            for (int[] dir : dirs) {
                dfs(i + dir[0], j + dir[1], grid, dirs, queue, visited);
            }
        }
    }
}