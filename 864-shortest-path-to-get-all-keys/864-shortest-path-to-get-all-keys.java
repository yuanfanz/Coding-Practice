class Solution {
    public int shortestPathAllKeys(String[] input) {
        int m = input.length;
        int n = input[0].length();
        
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = input[i].charAt(j);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int totalKeys = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '@') {
                    queue.offer(new int[]{i, j, 0});
                }
                if (isKey(grid[i][j])) {
                    totalKeys |= (1 << (grid[i][j] - 'a'));
                }
            }
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Set<String> visited = new HashSet<>();
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                
                if (cur[2] == totalKeys) return level;
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    int key = cur[2];
                    
                    if (!isValid(grid, row, col, m, n)) continue;
                    char c = grid[row][col];
                    if (isLock(c)) {
                        // if (key & (1 << (c - 'A')) == 0) {
                        if ((key >> (c - 'A') & 1) == 0) {
                            continue;
                        }
                    } else if (isKey(c)) {
                        key |= (1 << (c - 'a'));
                    }
                    if (visited.add(row + " " + col + " " + key)) {
                        queue.offer(new int[]{row, col, key});
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    private boolean isValid(char[][] grid, int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != '#';
    }
    
    class Tuple{
        int i;
        int j;
        int key;
        public Tuple(int i, int j, int key) {
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }
}