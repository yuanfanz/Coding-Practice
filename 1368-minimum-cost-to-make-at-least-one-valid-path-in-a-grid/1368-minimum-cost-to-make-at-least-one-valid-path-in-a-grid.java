class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> deque = new LinkedList<>();
        deque.offerFirst(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[m][n];
        while (deque.size() > 0) {
            int[] cur = deque.pollFirst();
            int i = cur[0];
            int j = cur[1];
            int cost = cur[2];
            if (i == m - 1 && j == n - 1) return cost;
            
            if (visited[i][j]) continue;
            visited[i][j] = true;
            
            for (int k = 0; k < 4; ++k) {
                int row = i + dirs[k][0];
                int col = j + dirs[k][1];
                if (row < 0 || col < 0 || row >= m || col >= n) continue;
                if (grid[i][j] != k + 1) {
                    deque.offerLast(new int[]{row, col, cost + 1});
                } else {
                    deque.offerFirst(new int[]{row, col, cost});
                }
            }
        }
        return 0;
    }
}