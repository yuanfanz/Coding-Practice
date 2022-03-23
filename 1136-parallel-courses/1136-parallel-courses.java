class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] cur : relations) {
            int prev = cur[0];
            int next = cur[1];
            indegree[next]++;
            List<Integer> list = map.getOrDefault(prev, new ArrayList<>());
            list.add(next);
            map.put(prev, list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                if (!map.containsKey(cur)) continue;
                for (int next : map.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        for (int i = 1; i <= n; ++i) {
            if (indegree[i] != 0) {
                return -1;
            }
        }
        return level;
    }
}