class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] player = new int[]{-1,-1};
        int[] box = new int[]{-1,-1};
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                }
                if (grid[i][j] == 'S') {
                    player = new int[]{i, j};
                }
            }
        }
        Map<int[], char[][]> tmpMap = new HashMap<>();
        int[] arr = new int[]{box[0], box[1], player[0], player[1]};
        tmpMap.put(arr, getGrid(grid));
        Queue<Map<int[], char[][]>> queue = new LinkedList<>();
        queue.offer(tmpMap);
        int count = 0;
        boolean[][][] visited = new boolean[m][n][4];
        while (queue.size() != 0) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; ++k) {
                Map<int[], char[][]> curMap = queue.poll();
                Map.Entry<int[], char[][]> entry = curMap.entrySet().iterator().next();
                int[] curArr = entry.getKey();
                char[][] curGrid = entry.getValue();
                for (int i = 0; i < 4; ++i) {
                    int[] dir = dirs[i];
                    int cur1 = curArr[0];
                    int cur2 = curArr[1];
                    if (visited[cur1][cur2][i]) continue;
                    
                    // first check if we can get to the push place
                    int player1 = cur1 + dir[0];
                    int player2 = cur2 + dir[1];
                    if (!isValid(player1, player2, curGrid) 
                        || !canAccess(player1, player2, curArr, curGrid, dirs)) {
                        continue;
                    }
                    
                    int box1 = cur1 - dir[0];
                    int box2 = cur2 - dir[1];
                    if (!isValid(box1, box2, curGrid)) continue;
                    
                    if (curGrid[box1][box2] == 'T') return count;
                    visited[cur1][cur2][i] = true;
                    char[][] nextGrid = getGrid(curGrid);
                    nextGrid[box1][box2] = 'B';
                    nextGrid[cur1][cur2] = '.';
                    Map<int[], char[][]> nextMap = new HashMap<>();
                    nextMap.put(new int[]{box1, box2, player1, player2}, nextGrid);
                    queue.offer(nextMap);
                }
            }
        }
        return -1;
    }
    private boolean canAccess(int row, int col, int[] curArr, char[][] grid, int[][] dirs) {
        int m= grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int cur1 = curArr[2];
        int cur2 = curArr[3];
        if (!dfs(row, col, cur1, cur2, grid, dirs, visited)) return false;
        return true;
    }
    private boolean dfs(int row, int col, int cur1, int cur2, char[][] grid, int[][] dirs,
                       boolean[][] visited) {
        if (!isValid(cur1, cur2, grid) || visited[cur1][cur2] || grid[cur1][cur2] == 'B') return false;
        
        if (row == cur1 && col == cur2) return true;
        visited[cur1][cur2] = true;
        boolean result = false;
        for (int[] dir : dirs) {
            result = result || dfs(row, col, cur1 + dir[0], cur2 + dir[1], grid, dirs, visited);
        }
        return result;
    }
    private boolean isValid(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length 
            || col >= grid[0].length || grid[row][col] == '#') return false;
        return true;
    }
    private char[][] getGrid(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        char[][] result = new char[m][n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result[i][j] = grid[i][j];
            }
        }
        return result;
    }
}








































