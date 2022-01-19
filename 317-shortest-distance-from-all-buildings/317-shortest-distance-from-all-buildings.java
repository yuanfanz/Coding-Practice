class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] reach = new int[m][n];
        int[][] distance = new int[m][n];
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        int totalBuildings = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[m][n];
                    queue.offer(new int[]{i, j, 1});
                    while (queue.size() != 0) {
                        int[] cur = queue.poll();
                        int dis = cur[2];
                        for (int[] dir : dirs) {
                            int row = cur[0] + dir[0];
                            int col = cur[1] + dir[1];
                            // if (row == 2 && col == 1) {
                            //     System.out.println(row);
                            //     System.out.println(col);
                            //     System.out.println(visited[row][col] + "");
                            //     System.out.println(grid[i][j]);
                            // }
                            if (row < 0 || col < 0 || row >= m || col >= n
                               || visited[row][col] || grid[row][col] > 0) {
                                continue;
                            }
                            // System.out.println("found");
                            visited[row][col] = true;
                            queue.offer(new int[]{row, col, dis + 1});
                            distance[row][col] += dis;
                            reach[row][col]++;
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && reach[i][j] == totalBuildings) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}