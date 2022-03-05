class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                if ((cur[0] != entrance[0] || cur[1] != entrance[1]) && 
                    (cur[0] == 0 || cur[0] == m - 1 || cur[1] == 0 || cur[1] == n - 1)) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n
                       || maze[row][col] == '+' || visited[row][col]) {
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