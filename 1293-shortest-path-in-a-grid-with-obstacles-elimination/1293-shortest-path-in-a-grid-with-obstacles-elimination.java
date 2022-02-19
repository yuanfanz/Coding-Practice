class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int g = 0; g < size; ++g) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if (i == m - 1 && j == n - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    int curK = cur[2];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    if (grid[row][col] == 1) {
                        curK++;
                    }
                    if (curK > k || visited[row][col][curK]) {
                        continue;
                    }
                    visited[row][col][curK] = true;
                    queue.offer(new int[]{row, col, curK});
                }
            }
            step++;
        }
        return -1;
    }
}













