class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }
        HashSet[] map = new HashSet[n];
        
        for (int i = 0; i < n; ++i) {
            map[i] = new HashSet<>();
        }
        for (int[] cur : edges) {
            int first = cur[0];
            int second = cur[1];
            map[first].add(second);
            map[second].add(first);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (map[i].size() == 1) {
                leaves.add(i);
            }
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i = 0; i < leaves.size(); ++i) {
                int cur = leaves.get(i);
                for (int j = 0; j < map[cur].size(); ++j) {
                    int next = (int) map[cur].iterator().next();
                    map[next].remove(cur);
                    if (map[next].size() == 1) {
                        newLeaves.add(next);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}