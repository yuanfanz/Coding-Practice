class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        } else if (n == 2) {
            result.add(0);
            result.add(1);
            return result;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            List<Integer> list1 = map.getOrDefault(p, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(q, new ArrayList<>());
            list1.add(q);
            list2.add(p);
            map.put(p, list1);
            map.put(q, list2);
            indegree[p]++;
            indegree[q]++;
        }
        int min = n + 1;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, indegree[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }
        while (n > 2 && queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                if (map.containsKey(cur)) {
                    for (int next : map.get(cur)) {
                        indegree[next]--;
                        if (indegree[next] == 1) {
                            queue.offer(next);
                        }
                    }
                }
            }
            n -= size;
        }
        while (queue.size() > 0) {
            result.add(queue.poll());
        }
        return result;
    }
}












