class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Set<String>> setMap = new HashMap<>();
        int n = synonyms.size() * 2;
        UnionFind uf = new UnionFind(n);
        int count = 0;
        for (List<String> list : synonyms) {
            String first = list.get(0);
            String second = list.get(1);
            if (!map.containsKey(first)) map.put(first, count);
            if (!map.containsKey(second)) map.put(second, count);
            uf.union(map.get(first), map.get(second));
            count++;
        }
        for (List<String> list : synonyms) {
            for (String s : list) {
                int root = uf.find(map.get(s));
                Set<String> set = setMap.getOrDefault(root, new HashSet<>());
                set.add(s);
                setMap.put(root, set);
            }
        }
        Set<String> result = new HashSet<>();
        String[] strs = text.split(" ");
        dfs(result, new StringBuilder(), strs, 0, uf, text, setMap, map);
        List<String> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }
    private void dfs(Set<String> result, StringBuilder sb, String[] strs, int index, UnionFind uf, String text,
                     Map<Integer, Set<String>> setMap, Map<String, Integer> map) {
        if (index == strs.length) {
            sb.setLength(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        int len = sb.length();
        if (!map.containsKey(strs[index])) {
            sb.append(strs[index] + " ");
            dfs(result, sb, strs, index + 1, uf, text, setMap, map);
            sb.setLength(len);
        } else {
            int root = uf.find(map.get(strs[index]));
            Set<String> set = setMap.get(root);
            if (set.size() == 0) return;
            for (String next : set) {
                sb.append(next + " ");
                dfs(result, sb, strs, index + 1, uf, text, setMap, map);
                sb.setLength(len);
            }
        }
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
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
            }
        }
    }
}