class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        
        set.add("0-0");
        int x = 0;
        int y = 0;
        // N (0, 1)
        // S (0, -1)
        // E (-1, 0)
        // W (1, 0)
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        for (int i = 0; i < path.length(); ++i) {
            char ch = path.charAt(i);
            if (ch == 'N') {
                x += dirs[0][0];
                y += dirs[0][1];
            } else if (ch == 'S') {
                x += dirs[1][0];
                y += dirs[1][1];
            } else if (ch == 'E') {
                x += dirs[2][0];
                y += dirs[2][1];
            } else if (ch == 'W') {
                x += dirs[3][0];
                y += dirs[3][1];
            }
            String str = String.format(x + "-" + y);
            if (set.contains(str)) {
                return true;
            }
            set.add(str);
        }
        return false;
    }
}