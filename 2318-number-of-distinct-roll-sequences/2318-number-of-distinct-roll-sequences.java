class Solution {
    public int distinctSequences(int n) {
        if (n == 1) return 6;
        int mod = (int) Math.pow(10, 9) + 7;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(2, 3, 4, 5, 6));
        map.put(2, Arrays.asList(1, 3, 5));
        map.put(3, Arrays.asList(1, 2, 4, 5));
        map.put(4, Arrays.asList(1, 3, 5));
        map.put(5, Arrays.asList(1, 2, 3, 4, 6));
        map.put(6, Arrays.asList(1, 5));
        
        int[][] prev = new int[7][7];
        for (int i = 1; i <= 6; ++i) {
            for (int j : map.get(i)) {
                prev[i][j] = 1;
            }
        }
        //  .. _k _j _i ..
        for (int len = 3; len <= n; ++len) {
            int[][] cur = new int[7][7];
            for (int i = 1; i <= 6; ++i) {
                for (int j : map.get(i)) {
                    for (int k = 1; k <= 6; ++k) {
                        if (k != i) {
                            cur[i][j] += prev[j][k];
                            cur[i][j] %= mod;
                        }
                    }
                }
            }
            prev = cur;
        }
        int res = 0;
        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 6; ++j) {
                if (i == j) continue;
                res += prev[i][j];
                res %= mod;
            }
        }
        return res;
    }
}