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
        if (remain < 0) return 0;
        if (cache[cur][remain] != -1) {
            return cache[cur][remain];
        }
        // no more fuel, cannot move
        if (remain == 0 && cur != end) {
            cache[cur][remain] = 0;
            return 0;
        }
        // not enough fuel, cannot move
        boolean canMove = false;
        for (int i = 0; i < locations.length; ++i) {
            if (i == cur) continue;
            if (Math.abs(locations[i] - locations[cur]) <= remain) {
                canMove = true;
                break;
            }
        }
        if (remain != 0 && !canMove) {
            int way = cur == end ? 1 : 0;
            cache[cur][remain] = way;
            return way;
        }
        
        int count = cur == end ? 1 : 0;
        for (int i = 0; i < locations.length; ++i) {
            if (i == cur) continue;
            int need = Math.abs(locations[i] - locations[cur]);
            if (remain >= need) {
                count += dfs(i, end, locations, remain - need, cache);
                count %= mod;
            }
        }
        cache[cur][remain] = count;
        return count;
    }
}

















