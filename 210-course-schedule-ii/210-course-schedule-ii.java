class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] cur : prerequisites) {
            int precourse = cur[1];
            int curcourse = cur[0];
            List<Integer> list = map.getOrDefault(precourse, new ArrayList<>());
            list.add(curcourse);
            map.put(precourse, list);
            indegree[curcourse]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        boolean[] visited = new boolean[numCourses];
        int count = 0;
        while (queue.size() != 0) {
            int cur = queue.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            result.add(cur);
            count++;
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count != numCourses ? new int[0] : result.stream().mapToInt(i -> i).toArray();
    }
}