class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        int root = uf.find(0);
        Map<Integer, List<int[]>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < meetings.length; ++i) {
            int time = meetings[i][2];
            List<int[]> list = map.getOrDefault(time, new ArrayList<>());
            list.add(new int[]{meetings[i][0], meetings[i][1]});
            min = Math.min(min, time);
            max = Math.max(max, time);
            map.put(time, list);
        }
        for (int i = min; i <= max; ++i) {
            if (!map.containsKey(i)) continue;
            Set<Integer> set = new HashSet<>();
            for (int[] cur : map.get(i)) {
                int first = cur[0];
                int second = cur[1];
                set.add(first);
                set.add(second);
                uf.union(first, second);
            }
            for (int num : set) {
                if (uf.find(num) != root) {
                    uf.reset(num);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (uf.find(i) == root) {
                result.add(i);
            }
        }
        return result;
    }
    
    class UnionFind{
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rootP < rootQ) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
            }
        }
        public void reset(int p) {
            parent[p] = p;
        }
    }
}