class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList[] fromMap = new ArrayList[n];
        ArrayList[] toMap = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            fromMap[i] = new ArrayList<>();
            toMap[i] = new ArrayList<>();
        }
        for (int[] cur : connections) {
            int from = cur[0];
            int to = cur[1];
            fromMap[from].add(to);
            toMap[to].add(from);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int count = 0;
        boolean[] visited = new boolean[n];
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                if (visited[cur]) continue;
                visited[cur] = true;
                for (int j = 0; j < toMap[cur].size(); ++j) {
                    int next = (int) toMap[cur].get(j);
                    queue.offer(next);
                }
                for (int j = 0; j < fromMap[cur].size(); ++j) {
                    int next = (int) fromMap[cur].get(j);
                    if (visited[next]) continue;
                    queue.offer(next);
                    // System.out.println(next);
                    count++;
                }
            }
        }
        return count;
    }
}