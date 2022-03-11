class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[arr.length];
        while (queue.size() > 0) {
            int cur = queue.poll();
            if (arr[cur] == 0) return true;
            if (visited[cur]) continue;
            visited[cur] = true;
            int first = cur - arr[cur];
            int second = cur + arr[cur];
            if (first >= 0) {
                queue.offer(first);
            }
            if (second < arr.length) {
                queue.offer(second);
            }
        }
        return false;
    }
}