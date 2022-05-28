class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] cur : roads) {
            int p = cur[0];
            int q = cur[1];
            List<Integer> plist = map.getOrDefault(p, new ArrayList<>());
            List<Integer> qlist = map.getOrDefault(q, new ArrayList<>());
            plist.add(q);
            qlist.add(p);
            map.put(p, plist);
            map.put(q, qlist);
            indegree.put(p, indegree.getOrDefault(p, 0) + 1);
            indegree.put(q, indegree.getOrDefault(q, 0) + 1);
        }
        int[] values = new int[n];
        int curValue = n;
        List<Tuple> list = new ArrayList<>();
        for (int key : indegree.keySet()) {
            list.add(new Tuple(key, indegree.get(key)));
        }
        Collections.sort(list, (a, b) -> b.indegree - a.indegree);
        
        for (int i = 0; i < list.size(); ++i) {
            Tuple tuple = list.get(i);
            values[tuple.id] = curValue;
            curValue--;
        }
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int key : map.keySet()) {
            if (set.contains(key)) continue;
            List<Integer> curlist = map.get(key);
            set.add(key);
            
            for (int next : curlist) {
                if (set.contains(next)) continue;
                sum += values[key];
                sum += values[next];
            }
        }
        return sum;
    }
    
    class Tuple{
        int id;
        int indegree;
        public Tuple(int id, int indegree) {
            this.id = id;
            this.indegree = indegree;
        }
    }
}



