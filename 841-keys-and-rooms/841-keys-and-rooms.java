class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        while (queue.size() > 0) {
            int cur = queue.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            for (int next : rooms.get(cur)) {
                queue.offer(next);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}