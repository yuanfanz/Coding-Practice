class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int[] start = new int[2];
        Set<String> endSet = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '*') {
                    start[0] = i;
                    start[1] = j;
                }
                if (grid[i][j] == '#') {
                    endSet.add(i + "_" + j);
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        while (queue.size() > 0) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if (endSet.contains(i + "_" + j)) return step;
                if (visited[i][j]) continue;
                visited[i][j] = true;
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    if (grid[row][col] == 'X') continue;
                    queue.offer(new int[]{row, col});
                }
            }
            step++;
        }
        return -1;
    }
}














