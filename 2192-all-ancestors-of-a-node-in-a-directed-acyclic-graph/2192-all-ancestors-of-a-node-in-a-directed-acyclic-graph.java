class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] indegree = new int[n];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] cur : edges) {
            int from = cur[0];
            int to = cur[1];
            List<Integer> list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
            indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet[] arr = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = new HashSet<>();
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int parent = queue.poll();
            if (!map.containsKey(parent)) continue;
            for (int child : map.get(parent)) {
                arr[child].add(parent);
                arr[child].addAll(arr[parent]);
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> list = new ArrayList<>(new TreeSet<>(arr[i]));
            result.add(list);
        }
        return result;
    }
}