class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (List<Integer> list : connections) {
            int p = list.get(0);
            int q = list.get(1);
            List<Integer> list1 = map.getOrDefault(p, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(q, new ArrayList<>());
            list1.add(q);
            list2.add(p);
            map.put(p, list1);
            map.put(q, list2);
        }
        int[] id = new int[n];
        Arrays.fill(id, -1);
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, 0, -1, id, map, result);
        
        return result;
    }
    
    private int dfs(int cur, int curId, int parent, int[] id,
                    Map<Integer, List<Integer>> map, List<List<Integer>> result) {
        id[cur] = curId;
        
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (next == parent) {
                    continue;
                } else if (id[next] == -1) {
                    id[cur] = Math.min(id[cur], dfs(next, curId + 1, cur, id, map, result));
                } else {
                    id[cur] = Math.min(id[cur], id[next]);
                }
            }
        }
        
        if (cur != 0 && id[cur] == curId) {
            result.add(Arrays.asList(cur, parent));
        }
        return id[cur];
    }
}




















