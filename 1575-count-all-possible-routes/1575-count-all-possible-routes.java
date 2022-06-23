class Solution {
    private int mod = (int) Math.pow(10, 9) + 7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        
        int[][] cache = new int[n][fuel + 1];
        for (int[] cur : cache) {
            Arrays.fill(cur, -1);
        }
        return dfs(start, finish, locations, fuel, cache);
    }
    
    private int dfs(int cur, int end, int[] locations, int remain, int[][] cache) {
        if (cache[cur][remain] != -1) {
            return cache[cur][remain];
        }
        // 如果一步到达不了，说明从位置 u 不能到达 end 位置
        // 将结果 0 写入缓存器并返回
        int need = Math.abs(locations[cur] - locations[end]);
        if (need > remain) {
            cache[cur][remain] = 0;
            return 0;
        }
        // if already at finish point, it is 1 way
        int count = cur == end ? 1 : 0;
        for (int i = 0; i < locations.length; ++i) {
            if (i == cur) continue;
            need = Math.abs(locations[i] - locations[cur]);
            if (remain >= need) {
                count += dfs(i, end, locations, remain - need, cache);
                count %= mod;
            }
        }
        cache[cur][remain] = count;
        return count;
    }
}