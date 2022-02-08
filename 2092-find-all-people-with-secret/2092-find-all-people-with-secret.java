class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        int root = uf.find(0);
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] cur : meetings) {
            List<int[]> list = map.getOrDefault(cur[2], new ArrayList<>());
            list.add(cur);
            map.put(cur[2], list);
            min = Math.min(min, cur[2]);
            max = Math.max(max, cur[2]);
        }
        for (int time = min; time <= max; ++time) {
            if (!map.containsKey(time)) continue;
            Set<Integer> set = new HashSet<>();
            for (int[] cur : map.get(time)) {
                uf.union(cur[0], cur[1]);
                set.add(cur[0]);
                set.add(cur[1]);
            }
            for (int num : set) {
                if (uf.find(num) != root) {
                    uf.reset(num);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int cur = uf.find(i);
            if (cur == root) {
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