class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] reach = new int[m][n];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] distance = new int[m][n];
        int totalBuildings = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    int level = 1;
                    boolean[][] visited = new boolean[m][n];
                    while (queue.size() > 0) {
                        int size = queue.size();
                        for (int k = 0; k < size; ++k) {
                            int[] cur = queue.poll();
                            // System.out.println(cur[0] + " " + cur[1]);
                            for (int[] dir : dirs) {
                                int row = cur[0] + dir[0];
                                int col = cur[1] + dir[1];
                                if (row < 0 || col < 0 || row >= m || col >= n) continue;
                                if (visited[row][col]) continue;
                                visited[row][col] = true;
                                if (grid[row][col] != 0) continue;
                                distance[row][col] += level;
                                queue.offer(new int[]{row, col});
                                reach[row][col]++;
                            }
                        }
                        // System.out.println();
                        level++;
                    }
                }
            }
        }
        // print(distance);
        // System.out.println();
        // print(reach);
        // System.out.println("totalBuildings "+totalBuildings);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 0 || reach[i][j] != totalBuildings) continue;
                min = Math.min(min, distance[i][j]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
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