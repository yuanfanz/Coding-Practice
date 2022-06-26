class Solution {
    private int clock;
    private int[] xor;
    private int[] in;
    private int[] out;
    
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        // first draw the graph
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            List<Integer> list1 = map.getOrDefault(p, new ArrayList<>());
            list1.add(q);
            map.put(p, list1);
            List<Integer> list2 = map.getOrDefault(q, new ArrayList<>());
            list2.add(p);
            map.put(q, list2);
        }
        xor = new int[n];
        in = new int[n];
        out = new int[n];
        // dfs to build in and out clock array
        // this will build the parent-child relations for nodes
        dfs(map, nums, 0, -1);
        
        int res = Integer.MAX_VALUE;
        // two for loops to enumerate the possible removals 
        for (int i = 2; i < n; ++i) {
            for (int j = 1; j < i; ++j) {
                int x = 0;
                int y = 0;
                int z = 0;
                if (isAncestor(i, j)) { // i is ancestor to j
                    x = xor[j];
                    y = xor[i] ^ x;
                    z = xor[0] ^ xor[i];
                } else if (isAncestor(j, i)) { // j is ancestor to i
                    x = xor[i];
                    y = xor[j] ^ x;
                    z = xor[0] ^ xor[j];
                } else { // i and j they are from 2 different subtrees
                    x = xor[i];
                    y = xor[j];
                    z = xor[0] ^ x ^ y;
                }
                // update the minimum of xor of (max - min)
                res = Math.min(res, Math.max(Math.max(x, y), z) - Math.min(Math.min(x, y), z));
                if (res == 0) return 0; // 0 is the minimum possible
            }
        }
        return res;
    }
    
    private void dfs(Map<Integer, List<Integer>> map, 
                     int[] nums, int node, int parent) {
        // only increase clock when going into a new node
        in[node] = ++clock;
        xor[node] = nums[node];
        for (int next : map.get(node)) {
            // we dont dfs back
            if (next != parent) {
                dfs(map, nums, next, node);
                xor[node] ^= xor[next];
            }
        }
        out[node] = clock;
    }
    
    private boolean isAncestor(int x, int y) {
        return in[x] < in[y] && in[y] <= out[x];
    }
}