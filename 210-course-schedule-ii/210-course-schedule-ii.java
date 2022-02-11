class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] indegree = new int[numCourses];
        for (int[] cur : prerequisites) {
            int pre = cur[1];
            indegree[cur[0]]++;
            List<Integer> list = map.getOrDefault(pre, new ArrayList<>());
            list.add(cur[0]);
            map.put(pre, list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (queue.size() != 0) {
            int cur = queue.poll();
            list.add(cur);
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return list.size() != numCourses ? new int[0] : list.stream().mapToInt(i -> i).toArray();
    }
}