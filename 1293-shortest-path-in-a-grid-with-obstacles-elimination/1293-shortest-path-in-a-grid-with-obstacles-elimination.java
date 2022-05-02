class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int[][] visited = new int[m][n];
        for (int[] cur : visited) {
            Arrays.fill(cur, -1);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    int curK = cur[2];
                    if (grid[row][col] == 1) {
                        curK++;
                    }
                    if (curK > k || visited[row][col] != -1 && curK >= visited[row][col]) {
                        continue;
                    }
                    visited[row][col] = curK;
                    queue.offer(new int[]{row, col, curK});
                }
            }
            step++;
        }
        return -1;
    }
}