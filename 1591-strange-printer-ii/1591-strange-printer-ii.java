class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] indegree = new int[61];
        for (int i = 1; i <= 60; ++i) {
            search(indegree, targetGrid, i, map);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 60; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (queue.size() > 0) {
            int cur = queue.poll();
            count++;
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count == 60;
    }
    
    private void search(int[] indegree, int[][] grid, 
                        int color, Map<Integer, List<Integer>> map) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == color) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        // if there is no such color
        if (minRow == Integer.MAX_VALUE) return;
        // go through grid to find topological order for this color
        for (int i = minRow; i <= maxRow; ++i) {
            for (int j = minCol; j <= maxCol; ++j) {
                // this means new color painted after current color
                if (grid[i][j] != color) {
                    List<Integer> list = map.getOrDefault(color, new ArrayList<>());
                    list.add(grid[i][j]);
                    map.put(color, list);
                    indegree[grid[i][j]]++;
                }
            }
        }
    }
}