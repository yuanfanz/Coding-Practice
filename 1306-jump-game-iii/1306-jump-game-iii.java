class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        int n = arr.length;
        boolean[] visited = new boolean[n];
        while (queue.size() > 0) {
            int cur = queue.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            int jump = arr[cur];
            if (arr[cur] == 0) return true;
            if (cur + jump < n) {
                queue.offer(cur + jump);
            }
            if (cur - jump >= 0) {
                queue.offer(cur - jump);
            }
        }
        return false;
    }
}