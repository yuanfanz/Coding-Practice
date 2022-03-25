class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else {
                    fresh++;
                }
            }
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            if (fresh == 0) return level;
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n) continue;
                    if (grid[row][col] == 1) {
                        fresh--;
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                    }
                }   
            }
            level++;
        }
        return fresh == 0 ? level : -1;
    }
}