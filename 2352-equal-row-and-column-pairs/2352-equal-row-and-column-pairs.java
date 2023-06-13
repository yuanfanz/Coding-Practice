class Solution {
    public int equalPairs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<String, Integer> row = new HashMap<>();
        Map<String, Integer> col = new HashMap<>();
        long count = 0;
        for (int i = 0; i < m; ++i) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                sb.append(grid[i][j] + "_");
                sb2.append(grid[j][i] + "_");
            }
            String s1 = sb.toString();
            String s2 = sb2.toString();
            row.put(s1, row.getOrDefault(s1, 0) + 1);
            col.put(s2, col.getOrDefault(s2, 0) + 1);
        }
        for (String s1 : row.keySet()) {
            if (col.containsKey(s1)) {
                // System.out.println("s1  " + s1);
                // System.out.println("col.get(s1)  " + col.get(s1));
                count += row.get(s1) * col.get(s1);
            }
        }
        return (int) count;
    }
}