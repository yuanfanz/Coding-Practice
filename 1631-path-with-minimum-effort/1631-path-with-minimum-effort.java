class Solution {
    public int minimumEffortPath(int[][] heights) {
        Map<String, List<int[]>> map = new HashMap<>();
        
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] visited = new int[m][n];
        for (int[] cur : visited) {
            Arrays.fill(cur, -1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int max = cur[2];
            if (i == m - 1 && j == n - 1) {
                return max;
            }
            if (visited[i][j] != -1 && visited[i][j] <= max) continue;
            visited[i][j] = max;
            // System.out.print(i + " ");
            // System.out.println(j);
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n) continue;
                pq.offer(new int[]{row, col, 
                    Math.max(max, Math.abs(heights[row][col] - heights[i][j]))});
            }
        }
        return -1;
    }
}





















