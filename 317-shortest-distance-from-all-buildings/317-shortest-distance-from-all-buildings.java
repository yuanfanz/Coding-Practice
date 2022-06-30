class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int total = 0;
        int[][] dis = new int[m][n];
        int[][] reach = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    total++;
                    bfs(i, j, grid, dis, reach);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (reach[i][j] != total || grid[i][j] != 0) continue;
                min = Math.min(min, dis[i][j]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void bfs(int i, int j, int[][] grid, int[][] dis, int[][] reach) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, 0});
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        reach[i][j]++;
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int cost = cur[2];
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n) {
                    continue;
                }
                if (visited[row][col] || grid[row][col] != 0) continue;
                visited[row][col] = true;
                reach[row][col]++;
                dis[row][col] += cost + 1;
                queue.offer(new int[]{row, col, cost + 1});
            }
        }
    }
    
    private void print(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}



















