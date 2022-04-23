class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            List<Integer> list1 = map.getOrDefault(p, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(q, new ArrayList<>());
            list1.add(q);
            list2.add(p);
            map.put(p, list1);
            map.put(q, list2);
        }
        int[] res = new int[n];
        int[] count = new int[n];
        
        dfs(0, -1, map, res, count);
        dfs2(0, -1, map, res, count);
        return res;
    }
    
    private void dfs(int cur, int parent, Map<Integer, List<Integer>> map,
                    int[] res, int[] count) {
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (next == parent) continue;
                dfs(next, cur, map, res, count);
                count[cur] += count[next];
                res[cur] += res[next] + count[next];
            }
        }
        count[cur]++;
    }
    
    private void dfs2(int cur, int parent, Map<Integer, List<Integer>> map,
                    int[] res, int[] count) {
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (next == parent) continue;
                res[next] = res[cur] + (count.length - count[next]) - count[next];
                dfs2(next, cur, map, res, count);
            }
        }
    }
}














