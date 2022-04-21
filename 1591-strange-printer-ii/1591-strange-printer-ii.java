class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 1; i <= 60; ++i) {
            search(targetGrid, i, map);
        }
        int[] visited = new int[61];
        for (int i = 1; i <= 60; ++i) {
            if (visited[i] != 0) continue;
            if (dfs(map, i, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int color, int[] visited) {
        visited[color] = 1;
        if (map.containsKey(color)) {
            for (int next : map.get(color)) {
                if (visited[next] == 1) return true;
                if (visited[next] == 0) {
                    if (dfs(map, next, visited)) {
                        return true;
                    }
                }
            }
        }
        visited[color] = 2;
        return false;
    }
    
    private void search(int[][] grid, int color, Map<Integer, List<Integer>> map) {
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
                }
            }
        }
    }
}