class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Set<Integer>[] parent = new Set[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            parent[i] = new HashSet<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] cur : prerequisites) {
            int p = cur[0];
            int child = cur[1];
            List<Integer> list = map.getOrDefault(p, new ArrayList<>());
            list.add(child);
            indegree[child]++;
            map.put(p, list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int cur = queue.poll();
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    Set<Integer> childParentSet = parent[next];
                    childParentSet.add(cur);
                    childParentSet.addAll(parent[cur]);
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] cur : queries) {
            int p = cur[0];
            int q = cur[1];
            result.add(parent[q].contains(p));
        }
        return result;
    }
}










